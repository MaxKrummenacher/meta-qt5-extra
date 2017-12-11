SUMMARY = "Abstraction for system notifications"
LICENSE = "MIT & LGPLv2.1"
LIC_FILES_CHKSUM = " \
	file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
	file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1 \
"

inherit kde-kf5

DEPENDS += " \
    kwindowsystem \
    kservice \
    kconfig \
    kiconthemes \
    kcodecs \
    kcoreaddons \
    phonon \
    libdbusmenu-qt5 \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "qtx11extras libxtst", "", d)} \
"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "ebd60e338a9e7b59a555a5d3cc0d7b5a"
SRC_URI[sha256sum] = "04f9d6d0209586bf00dd4dbc2714b384c1817f8ac2d9e24d1fafc2faeb8b51b7"

FILES_${PN} += "${datadir}/dbus-1 ${datadir}/kservicetypes5"
