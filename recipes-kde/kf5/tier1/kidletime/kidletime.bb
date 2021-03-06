SUMMARY = "Monitoring user activity"
LICENSE = "GPLv2 | LGPLv2.1"
LIC_FILES_CHKSUM = " \
	file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24 \
	file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
"

inherit kde-kf5

DEPENDS += "${@bb.utils.contains("DISTRO_FEATURES", "x11", "libxcb qtx11extras libxscrnsaver", "", d)}"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "6172497628a93f42a928a02ad97299f3"
SRC_URI[sha256sum] = "e99a07f814573526ed5141fc9e4bc2df12298df53a0d2787c3b7a4c3af915665"

FILES_${PN} += "${OE_QMAKE_PATH_PLUGINS}"
