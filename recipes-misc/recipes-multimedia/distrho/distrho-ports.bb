SUMMARY = "Collection of synthesizers and plugins"
HOMEPAGE = "http://distrho.sourceforge.net/ports"
LICENSE = "GPLv2 & LGPLv3"
LIC_FILES_CHKSUM = " \
    file://doc/GPL.txt;md5=4641e94ec96f98fabc56ff9cc48be14b \
    file://doc/LGPL.txt;md5=e6a600fd5e1d9cbde2d983680233ad02 \
"

SRC_URI = " \
    git://github.com/DISTRHO/DISTRHO-Ports.git \
    file://0001-disable-pitchedDelay-it-uses-double-precision-SSE2-b.patch \
    file://0002-Refine-Plugin-do-not-include-xmmintrin.h.patch \
    file://0003-do-not-build-equinox-LV2-plugin-lv2_ttl_generator-bl.patch \
    file://0004-do-not-build-drowaudio-tremolo-LV2-plugin-lv2_ttl_ge.patch \
    file://0005-do-not-build-drumsynth-LV2-plugin-lv2_ttl_generator-.patch \
    file://0006-do-not-build-HiReSam-LV2-plugin-lv2_ttl_generator-bl.patch \
"

SRCREV = "e11e2b204c14b8e370a0bf5beafa5f162fedb8e9"
S = "${WORKDIR}/git"
PV = "0.0.0+git${SRCPV}"

REQUIRED_DISTRO_FEATURES = "x11"

inherit qemu-ext distro_features_check

DEPENDS += "\
    premake3-native \
    alsa-lib \
    libx11 \
    libxext \
    libxcursor \
    freetype \
    ladspa-sdk \
"

CLEANBROKEN = "1"

do_configure_prepend() {
	# manipulate scripts to keep lv2_ttl_generator-calls in script for qemu
    sed -i 's|$GEN ./$FILE|echo `pwd`/$FILE >> ${WORKDIR}/lv2_ttl_generator-data|g' `find ${S} -name *.sh`
}

# platforms supporting sse2 can override this
do_configure() {
    NOOPTIMIZATIONS=1 ${S}/scripts/premake-update.sh linux
}

do_compile_append() {
    # build ttl-files must be done in quemu
    for sofile in `cat ${WORKDIR}/lv2_ttl_generator-data`; do
        cd `dirname ${sofile}`
        echo "QEMU lv2_ttl_generator for ${sofile}..."
        ${@qemu_run_binary_local(d, '${STAGING_DIR_TARGET}', '${S}/libs/lv2_ttl_generator')} ${sofile} || echo "ERROR: for QEMU lv2_ttl_generator for ${sofile}!"
    done
}

do_install() {
    install -d ${D}${libdir}
	cp -r ${S}/bin/* ${D}${libdir}
    # don't install crash data
    rm `find ${D}${libdir} -name *.core` || true
}

FILES_${PN} += " \
    ${libdir}/lv2 \
    ${libdir}/vst \
"

# Have not found what causes stripping - debugging of plugins is unlikely
INSANE_SKIP_${PN} = "already-stripped"

