SUMMARY = "LSP (Linux Studio Plugins) is a collection of open-source plugins"
HOMEPAGE = "http://lsp-plug.in/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=0a6dbe4ab31bc5f5bfbf7de95d227934"

inherit autotools-brokensep pkgconfig

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    php-native \
    gtk+ \
    gtk+3 \
    jack \
    libsndfile1 \
"

SRC_URI = " \
    svn://svn.code.sf.net/p/lsp-plugins/svn;module=trunk;rev=8;protocol=https \
    file://0001-Makefile-align-for-oe-cross-build.patch \
"
S = "${WORKDIR}/trunk/${BPN}"

export BIN_PATH = "${bindir}"
export LIB_PATH = "${libdir}"
export DOC_PATH = "${datadir}"
export CPU_ARCH = "cross"
export VERSION  = "${PV}"
