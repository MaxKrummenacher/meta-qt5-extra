SUMMARY = "Advanced internationalization framework"
LICENSE = "BSD & LGPLv2.1"
LIC_FILES_CHKSUM = " \
	file://COPYING-CMAKE-SCRIPTS;md5=3775480a712fc46a69647678acb234cb \
	file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
"

inherit kde-kf5

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "2178c765e29675b21a044fc074a01246"
SRC_URI[sha256sum] = "bbd60981c9a0c1f9d9a52c8dd86adef7c4c30caf603f806d8730febaa36f0dd9"
