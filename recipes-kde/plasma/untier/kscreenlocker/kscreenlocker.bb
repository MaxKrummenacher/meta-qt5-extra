SUMMARY = "Library and components for secure lock screen architecture"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
"

REQUIRED_DISTRO_FEATURES = "x11"

inherit kde-plasma distro_features_check

DEPENDS += " \
    plasma-framework \
    kcmutils \
    kdeclarative \
    kidletime \
    kdelibs4support \
    kcrash \
    kglobalaccel \
    libxcb \
    qtx11extras \
"

PV = "${PLASMA_VERSION}"
SRC_URI[md5sum] = "a93a609de1d346927399c6c12bf60843"
SRC_URI[sha256sum] = "87e049ea0771a72e2919fb618348c58f56b476d520f57ce7c269e877341a4464"

SRC_URI += "file://kde.pam"

do_install_append() {
    install -d ${D}${sysconfdir}/pam.d
    install -m 644 ${WORKDIR}/kde.pam ${D}${sysconfdir}/pam.d/kde
}

FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${datadir}/kconf_update \
    ${datadir}/k*5 \
    ${datadir}/plasma \
    ${datadir}/ksmserver \
    ${sysconfdir} \
    ${OE_QMAKE_PATH_PLUGINS} \
"

FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_PLUGINS}/.debug \
"
