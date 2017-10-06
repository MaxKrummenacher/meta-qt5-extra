SUMMARY = "Advanced plugin and service introspection"
LICENSE = "GPLv2 | GPLv3 | LGPLv2.1"
LIC_FILES_CHKSUM = " \
	file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24 \
	file://COPYING.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
	file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
"

inherit kde-kf5 gettext

DEPENDS += "kconfig kcoreaddons kcrash kdbusaddons ki18n kdoctools kdoctools-native"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "25d13fea84f873dd73832b0503493106"
SRC_URI[sha256sum] = "2d31c96d8fad235aa2bfc96258ac03d7ec064184fe6a54856f9d7407fbae4a7d"

FILES_${PN} += "${datadir}/kservicetypes5"


