SUMMARY = "OXYGEN"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24 \
    file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c \
"

inherit kde-plasma

DEPENDS += " \
    ki18n \
    kconfig \
    kguiaddons \
    kwidgetsaddons \
    kservice \
    kcompletion \
    frameworkintegration \
    kwindowsystem \
    kdecoration \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "libxcb qtx11extras", "", d)} \
"


PV = "${PLASMA_VERSION}"
SRC_URI[md5sum] = "728854b860b8b9ef8706ba1e708c8d77"
SRC_URI[sha256sum] = "d76b3f5ce15808805a1b6762c01bf103ded56caf14a80750324d851b6dc3e37d"
SRC_URI += "file://0001-kstyle-add-an-option-BUILD_OXYGEN_SETTINGS-disabled-.patch"

PACKAGECONFIG ??= ""
PACKAGECONFIG[settings] = "-DBUILD_OXYGEN_SETTINGS=ON,-DBUILD_OXYGEN_SETTINGS=OFF,kcmutils"

FILES_${PN} += " \
    ${datadir}/icons \
    ${datadir}/kservices5 \
    ${datadir}/kstyle \
    ${datadir}/plasma \
    ${OE_QMAKE_PATH_PLUGINS} \
"

FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_PLUGINS}/.debug \
    ${OE_QMAKE_PATH_PLUGINS}/*/.debug \
"
