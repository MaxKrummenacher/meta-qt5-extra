SUMMARY = "Advanced embeddable text editor"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = " \
	file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
"

inherit kde-kf5

DEPENDS += "qtxmlpatterns syntax-highlighting karchive kconfig kguiaddons ki18n kio kparts sonnet libgit2"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "f7fa45ec348426e7c1984ccbcfbd3197"
SRC_URI[sha256sum] = "31e7b3118a2cb56176d85538ef43f41842add3ef5c881786a7db7122c37ebea4"

EXTRA_OECMAKE += "-DBUILD_TESTING=OFF"

FILES_${PN} += " \
    ${datadir}/k*5 \
    ${datadir}/dbus-1 \
    ${datadir}/polkit-1 \
    ${OE_QMAKE_PATH_PLUGINS} \
"
FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_PLUGINS}/kf5/parts/.debug \
"
