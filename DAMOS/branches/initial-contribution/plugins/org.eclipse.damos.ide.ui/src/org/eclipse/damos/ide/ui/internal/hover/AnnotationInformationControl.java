/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.ide.ui.internal.hover;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.Assert;
import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.damos.ide.ui.internal.registry.QuickFixProviderRegistry;
import org.eclipse.damos.ide.ui.internal.util.ProblemUtil;
import org.eclipse.damos.ide.ui.quickfix.IQuickFix;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.AbstractInformationControl;
import org.eclipse.jface.text.IInformationControlExtension2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;

/*
 * Classes of this package have been copied from other Eclipse projects like Jface and Xtext,
 * since only parts of the required classes are public API.
 * 
 * TODO: Clean-up this code
 */

public class AnnotationInformationControl extends AbstractInformationControl implements IInformationControlExtension2 {

		private Control fFocusControl;
		private AnnotationInfo fInput;
		private Composite fParent;

		public AnnotationInformationControl(Shell parentShell, String statusFieldText) {
			super(parentShell, statusFieldText);
			create();
		}

		public AnnotationInformationControl(Shell parentShell, ToolBarManager toolBarManager) {
			super(parentShell, toolBarManager);
			create();
		}
		
		public AnnotationInformationControl(Shell parentShell, boolean resizeable) {
			super(parentShell, resizeable);
			create();
		}		

		/*
		 * @see org.eclipse.jface.text.IInformationControl#setInformation(java.lang.String)
		 */
		@Override
		public void setInformation(String information) {
			//replaced by IInformationControlExtension2#setInput
		}
		
		public void setInput(Object input) {
			Assert.isLegal(input instanceof AnnotationInfo);
			fInput= (AnnotationInfo)input;
			disposeDeferredCreatedContent();
			deferredCreateContent();
		}

		public boolean hasContents() {
			return fInput != null;
		}

		private AnnotationInfo getAnnotationInfo() {
			return fInput;
		}

		@Override
		public void setFocus() {
			super.setFocus();
			if (fFocusControl != null)
				fFocusControl.setFocus();
		}

		@Override
		public final void setVisible(boolean visible) {
			if (!visible)
				disposeDeferredCreatedContent();
			super.setVisible(visible);
		}

		protected void disposeDeferredCreatedContent() {
			Control[] children= fParent.getChildren();
			for (int i= 0; i < children.length; i++) {
				children[i].dispose();
			}
			ToolBarManager toolBarManager= getToolBarManager();
			if (toolBarManager != null)
				toolBarManager.removeAll();
		}

		/*
		 * @see org.eclipse.jface.text.AbstractInformationControl#createContent(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		protected void createContent(Composite parent) {
			fParent= parent;
			GridLayout layout= new GridLayout(1, false);
			layout.verticalSpacing= 0;
			layout.marginWidth= 0;
			layout.marginHeight= 0;
			fParent.setLayout(layout);
		}

		@Override
		public Point computeSizeHint() {
			Point preferedSize= getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT, true);

			Point constrains= getSizeConstraints();
			if (constrains == null)
				return preferedSize;

			Point constrainedSize= getShell().computeSize(constrains.x, SWT.DEFAULT, true);

			int width= Math.min(preferedSize.x, constrainedSize.x);
			int height= Math.max(preferedSize.y, constrainedSize.y);

			return new Point(width, height);
		}

		/**
		 * Fills the toolbar actions, if a toolbar is available. This
		 * is called after the input has been set.
		 */
		protected void fillToolbar() {
			ToolBarManager toolBarManager= getToolBarManager();
			if (toolBarManager == null)
				return;
			fInput.fillToolBar(toolBarManager, this);
			toolBarManager.update(true);
		}

		/**
		 * Create content of the hover. This is called after
		 * the input has been set.
		 */
		protected void deferredCreateContent() {
			fillToolbar();
			
			List<Label> separators = Collections.emptyList();

			List<Problem> liveProblems = getAnnotationInfo().liveProblems;
			List<Problem> fixedErrors = new ArrayList<Problem>();
			for (Problem resourceProblem : getAnnotationInfo().resourceProblems) {
				if (resourceProblem.getSeverity() >= IMarker.SEVERITY_WARNING && !liveProblems.contains(resourceProblem)) {
					fixedErrors.add(resourceProblem);
				}
			}
			
			List<Problem> problems = new ArrayList<Problem>(liveProblems.size() + fixedErrors.size());
			problems.addAll(liveProblems);
			problems.addAll(fixedErrors);
			
			int markersLeft = problems.size();
			for (Problem problem : problems) {
				boolean fixed = fixedErrors.contains(problem);
				createAnnotationInformation(fParent, problem, fixed);
				
				if (!fixed) {
					Collection<IQuickFix> quickFixes = QuickFixProviderRegistry.getInstance().getQuickFixes(problem);
					
					if (!quickFixes.isEmpty()) {
						createCompletionProposalsControl(fParent, quickFixes, problem);
					}
				}

				if (--markersLeft > 0) {
					Label separator = new Label(fParent, SWT.SEPARATOR | SWT.HORIZONTAL);
					separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
					if (separators.isEmpty()) {
						separators = new ArrayList<Label>();
					}
					separators.add(separator);
				}
			}
			
			setColorAndFont(fParent, fParent.getForeground(), fParent.getBackground(), JFaceResources.getDialogFont());
			for (Label separator : separators) {
				setColorAndFont(separator, Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_FOREGROUND), Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND), JFaceResources.getDialogFont());
			}

			fParent.layout(true);
		}

		private void setColorAndFont(Control control, Color foreground, Color background, Font font) {
			control.setForeground(foreground);
			control.setBackground(background);
			control.setFont(font);

			if (control instanceof Composite) {
				Control[] children= ((Composite) control).getChildren();
				for (int i= 0; i < children.length; i++) {
					setColorAndFont(children[i], foreground, background, font);
				}
			}
		}

		private void createAnnotationInformation(Composite parent, final Problem problem, boolean fixed) {
			Composite composite= new Composite(parent, SWT.NONE);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
			GridLayout layout= new GridLayout(2, false);
			layout.marginHeight= 2;
			layout.marginWidth= 2;
			layout.horizontalSpacing= 0;
			composite.setLayout(layout);

			final Label imageLabel= new Label(composite, SWT.NONE);
			GridData gridData= new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false);
			gridData.widthHint= 17;
			gridData.heightHint= 16;
			imageLabel.setLayoutData(gridData);
			Image image = ProblemUtil.getMarkerImage(problem.getSeverity(), fixed);
			imageLabel.setImage(image);

			StyledText text= new StyledText(composite, SWT.MULTI | SWT.WRAP | SWT.READ_ONLY);
			GridData data= new GridData(SWT.FILL, SWT.FILL, true, true);
			text.setLayoutData(data);
			String annotationText= problem.getMessage();
			if (annotationText != null)
				text.setText(annotationText);
		}

		private void createCompletionProposalsControl(Composite parent, Collection<IQuickFix> quickFixes, Problem problem) {
			Composite composite= new Composite(parent, SWT.NONE);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			GridLayout layout2= new GridLayout(1, false);
			layout2.marginHeight= 0;
			layout2.marginWidth= 0;
			layout2.verticalSpacing= 2;
			composite.setLayout(layout2);

			Label separator= new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
			GridData gridData= new GridData(SWT.FILL, SWT.CENTER, true, false);
			separator.setLayoutData(gridData);

			Label quickFixLabel= new Label(composite, SWT.NONE);
			GridData layoutData= new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
			layoutData.horizontalIndent= 4;
			quickFixLabel.setLayoutData(layoutData);
			String text;
			if (quickFixes.size() == 1) {
				// DIFF: replaced JavaHoverMessages with XtextUIMessages (4)
				text= "1 quick fix available:";
			} else {
				// DIFF: replaced JavaHoverMessages with XtextUIMessages (4)
				text= MessageFormat.format("{0} quick fixes available:", new Object[] { String.valueOf(quickFixes.size()) });
			}
			quickFixLabel.setText(text);

			setColorAndFont(composite, parent.getForeground(), parent.getBackground(), JFaceResources.getDialogFont());
			createCompletionProposalsList(composite, quickFixes, problem);
		}

		private void createCompletionProposalsList(Composite parent, Collection<IQuickFix> quickFixes, Problem problem) {
			final ScrolledComposite scrolledComposite= new ScrolledComposite(parent, SWT.V_SCROLL | SWT.H_SCROLL);
			GridData gridData= new GridData(SWT.FILL, SWT.FILL, true, true);
			scrolledComposite.setLayoutData(gridData);
			scrolledComposite.setExpandVertical(false);
			scrolledComposite.setExpandHorizontal(false);

			Composite composite= new Composite(scrolledComposite, SWT.NONE);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			GridLayout layout= new GridLayout(2, false);
			layout.marginLeft= 5;
			layout.verticalSpacing= 2;
			composite.setLayout(layout);
			
			List<Link> list= new ArrayList<Link>();
			for (IQuickFix quickFix : quickFixes) {
				list.add(createCompletionProposalLink(composite, quickFix, problem, 1));// Original link for single fix, hence pass 1 for count

				// DIFF: outcommented, no support of FixCorrectionProposal and ICleanUp (5)
//				if (proposals[i] instanceof FixCorrectionProposal) {
//					FixCorrectionProposal proposal= (FixCorrectionProposal)proposals[i];
//					int count= proposal.computeNumberOfFixesForCleanUp(proposal.getCleanUp());
//					if (count > 1) {
//						list.add(createCompletionProposalLink(composite, proposals[i], count));
//					}
//				}
			}
			final Link[] links= list.toArray(new Link[list.size()]);

			scrolledComposite.setContent(composite);
			setColorAndFont(scrolledComposite, parent.getForeground(), parent.getBackground(), JFaceResources.getDialogFont());

			Point contentSize= composite.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			composite.setSize(contentSize);

			Point constraints= getSizeConstraints();
			if (constraints != null && contentSize.x < constraints.x) {
				ScrollBar horizontalBar= scrolledComposite.getHorizontalBar();

				int scrollBarHeight;
				if (horizontalBar == null) {
					Point scrollSize= scrolledComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT);
					scrollBarHeight= scrollSize.y - contentSize.y;
				} else {
					scrollBarHeight= horizontalBar.getSize().y;
				}
				gridData.heightHint= contentSize.y - scrollBarHeight;
			}

			fFocusControl= links[0];
			for (int i= 0; i < links.length; i++) {
				final int index= i;
				final Link link= links[index];
				link.addKeyListener(new KeyListener() {
					public void keyPressed(KeyEvent e) {
						switch (e.keyCode) {
							case SWT.ARROW_DOWN:
								if (index + 1 < links.length) {
									links[index + 1].setFocus();
								}
								break;
							case SWT.ARROW_UP:
								if (index > 0) {
									links[index - 1].setFocus();
								}
								break;
							default:
								break;
						}
					}

					public void keyReleased(KeyEvent e) {
					}
				});

				link.addFocusListener(new FocusListener() {
					
					public void focusGained(FocusEvent e) {
						int currentPosition= scrolledComposite.getOrigin().y;
						int hight= scrolledComposite.getSize().y;
						int linkPosition= link.getLocation().y;

						if (linkPosition < currentPosition) {
							if (linkPosition < 10)
								linkPosition= 0;

							scrolledComposite.setOrigin(0, linkPosition);
						} else if (linkPosition + 20 > currentPosition + hight) {
							scrolledComposite.setOrigin(0, linkPosition - hight + link.getSize().y);
						}
					}

					public void focusLost(FocusEvent e) {
					}
					
				});
			}
		}

		private Link createCompletionProposalLink(Composite parent, final IQuickFix quickFix, final Problem problem, int count) {
			final boolean isMultiFix= count > 1;
			if (isMultiFix) {
				new Label(parent, SWT.NONE); // spacer to fill image cell
				parent= new Composite(parent, SWT.NONE); // indented composite for multi-fix
				GridLayout layout= new GridLayout(2, false);
				layout.marginWidth= 0;
				layout.marginHeight= 0;
				parent.setLayout(layout);
			}
			
			Label proposalImage= new Label(parent, SWT.NONE);
			proposalImage.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
			Image image= /*isMultiFix ? JavaPluginImages.get(JavaPluginImages.IMG_CORRECTION_MULTI_FIX) : */quickFix.getImage();
			if (image != null) {
				proposalImage.setImage(image);

				proposalImage.addMouseListener(new MouseListener() {

					public void mouseDoubleClick(MouseEvent e) {
					}

					public void mouseDown(MouseEvent e) {
					}

					public void mouseUp(MouseEvent e) {
						if (e.button == 1) {
							dispose();
							quickFix.run(problem);
						}
					}

				});
			}

			Link proposalLink= new Link(parent, SWT.WRAP);
			GridData layoutData= new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
			String linkText;
			if (isMultiFix) {
				// DIFF: XtextUIMessages (4)
				linkText= MessageFormat.format("XtextUIMessages.AnnotationWithQuickFixesHover_message_multipleQuickFix", new Object[] { String.valueOf(count) });
			} else {
				linkText= quickFix.getLabel();
			}
			proposalLink.setText("<a>" + linkText + "</a>"); //$NON-NLS-1$ //$NON-NLS-2$
			proposalLink.setLayoutData(layoutData);
			proposalLink.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					dispose();
					quickFix.run(problem);
				}
			});
			return proposalLink;
		}

	}
