SUMMARY = "Embedded JS"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = " \
	file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
"

inherit kde-kf5-porting-aids cmake_lib

DEPENDS += " \
    ${BPN}-native \
    qtsvg \
    qttools \
    kjs \
    ki18n \
    kdoctools \
"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "047b61f45a48cece8f7e565ae31a0a51"
SRC_URI[sha256sum] = "0afdf41564f2f00e98c13cb160e9405ac40c11836dc0f354b50f01418a3d6059"

# kjsembed's kjscmd5 is not required for build -> point to native dummy to make cmake happy
CMAKE_ALIGN_SYSROOT[1] = "KF5JsEmbed, -s${_IMPORT_PREFIX}/bin/kjscmd5, -S${STAGING_BINDIR_NATIVE}/kjscmd5"
