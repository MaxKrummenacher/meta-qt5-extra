SUMMARY = "Qt port of libfm - a library to build desktop file managers"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=435ed639f84d4585d93824e7da3d85da"

REQUIRED_DISTRO_FEATURES = "x11"

inherit lxqt pkgconfig distro_features_check cmake_auto_align_paths cmake_lib mime

DEPENDS += "qtx11extras glib-2.0 libfm menu-cache libxcb liblxqt"

CMAKE_ALIGN_FILES_FIND = "*targets.cmake"

SRCREV = "6f8c1e9c3c61aa7fb07f64300a78933dfe183460"
PV = "0.12.0"

FILES_${PN} += "${datadir}/mime"

RRECOMMENDS_${PN} = "gvfs gvfsd-trash eject"

CMAKE_ALIGN_SYSROOT[1] = "fm-qt, -S${libdir}/lib, -S${STAGING_LIBDIR}/lib"
CMAKE_ALIGN_SYSROOT[2] = "fm-qt, -S${libdir}/glib, -S${STAGING_LIBDIR}/glib"
CMAKE_ALIGN_SYSROOT[3] = "fm-qt, -S${includedir}, -S${STAGING_INCDIR}"
