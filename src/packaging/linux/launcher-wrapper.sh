#!/bin/sh
# GStreamer 1.24 wrapper — prepended to the jpackage launcher so the
# bundled GStreamer is found before any system version.
APPDIR="$(cd "$(dirname "$0")/.." && pwd -P)"

export LD_LIBRARY_PATH="${APPDIR}/lib/gst:${LD_LIBRARY_PATH:-}"
export GST_PLUGIN_PATH="${APPDIR}/lib/gst/plugins"
export GST_PLUGIN_SYSTEM_PATH_1_0="${APPDIR}/lib/gst/plugins"
export GST_REGISTRY_1_0="${XDG_CACHE_HOME:-${HOME}/.cache}/duckdash-gst-registry.bin"

exec "${APPDIR}/bin/DuckDash.real" "$@"