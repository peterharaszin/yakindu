Yakindu consists of different moduls. For each of these modules an top level folder containing individual trunk, tags, and branches folders. Thie different modules are separated in this way due to the fact that they have individual development cycles. Current modules are:

  * **BASE** - module for common infrastructure that is used by _SCT_ and _DAMOS_.
  * **DAMOS** - contains everything specific to _DAMOS_.
  * **SCT1** - the implementation of the 1.x versons of the _Statechart Tools_
  * **SCT2** - will contain the upcoming 2.x versions of the _Statechart Tools_

These module contain different versions and branches:

  * _SCT1/trunk_ - ongoing work on SCT for Helios (v 1.2)
  * _SCT1/branches/SCT\_1.1.x\_BRANCH_ - SCT for Galileo
  * _DAMOS/trunk_ - development for DAMOS 0.2 release
  * _DAMOS/tags/DSM\_0.1\_RELEASE_ - the current DAMOS 0.1 release (will be branched for maintenance releases)