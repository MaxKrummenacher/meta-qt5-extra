SUMMARY = "Support for downloading application assets from the network"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

inherit kde-kf5

DEPENDS += " \
    karchive \
    kcompletion \
    kconfig \
    kcoreaddons \
    ki18n \
    kiconthemes \
    kio \
    kitemviews \
    ktextwidgets \
    kwidgetsaddons \
    kxmlgui \
    attica \
"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "e3ecbab2d0aef7ab54137dd10f260199"
SRC_URI[sha256sum] = "e433b952b979ffe039758c73c27e81f429aadc200323c190f4673315b97e3849"

FILES_${PN} += " \
    ${OE_QMAKE_PATH_QML}/org/kde/newstuff \
"
