SUMMARY = "Baloo provides searching and indexing infrastucture with an emphasis on files"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c \
"

inherit kde-kf5 cmake_auto_align_paths cmake_lib gtk-icon-cache

DEPENDS += " \
    ki18n \
    kconfig \
    kidletime \
    kauth \
    kcrash \
    solid \
    kio \
    kdbusaddons \
    kitemmodels \
    kfilemetadata \
    \
    xapian-core \
"

PV = "${KF5_VERSION}"
SRC_URI[md5sum] = "b7636f757203dc0c31bcebb9c43d82f4"
SRC_URI[sha256sum] = "290dd52f7c121f0b40eb0fe06dd18e05be88589df2b7b242882b889c80ee84ce"

SRC_URI += " \
    file://0001-fix-build-for-QT_NO_SESSIONMANAGER.patch \
    file://0002-do-not-create-dbus-xml-for-fileindexer-our-native-qd.patch \
    file://org.kde.baloo.fileindexer.xml \
"

do_configure_append() {
    # workaround broken native qdbuscpp2xml [1]. As long as this is necessary,
    # org.kde.baloo.fileindexer.xml must be created for each new version of baloo by:
    # 1. remove 0002-do-not-create-dbus-xml-for-fileindexer-our-native-qd.patch and do_configure_append
    # 2. Build baloo - if it crashes continue with 3.
    # 3. search log.do.compile for org.kde.baloo.fileindexer.xml and align command so that
    #    the file is created by host qdbuscpp2xml(-qt5)
    # 4. copy the file created to files
    mkdir -p ${B}/src/dbus
    cp -f ${WORKDIR}/org.kde.baloo.fileindexer.xml ${B}/src/dbus
}

CMAKE_ALIGN_SYSROOT[1] = "KF5Baloo, -S${libdir}, -S${STAGING_LIBDIR}"

FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${datadir}/icons \
    ${datadir}/kservices5 \
    ${OE_QMAKE_PATH_QML}/org/kde/baloo \
    ${OE_QMAKE_PATH_PLUGINS} \
"

FILES_${PN}-dbg += " \
    ${libdir}/*/.debug \
    ${OE_QMAKE_PATH_QML}/org/kde/baloo/.debug \
    ${OE_QMAKE_PATH_QML}/org/kde/baloo/experimental/.debug/ \
    ${OE_QMAKE_PATH_PLUGINS}/.debug \
    ${OE_QMAKE_PATH_PLUGINS}/kf5/*/.debug \
"
