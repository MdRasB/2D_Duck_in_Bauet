#!/bin/bash
# AppImage runtime entry point.
# $APPDIR is set automatically by the AppImage runtime to the squashfs mount point.

export LD_LIBRARY_PATH="${APPDIR}/lib/gst:${LD_LIBRARY_PATH:-}"
export GST_PLUGIN_PATH="${APPDIR}/lib/gst/plugins"
export GST_PLUGIN_SYSTEM_PATH_1_0="${APPDIR}/lib/gst/plugins"
export GST_REGISTRY_1_0="${XDG_CACHE_HOME:-${HOME}/.cache}/duckdash-gst-registry.bin"

exec "${APPDIR}/bin/DuckDash.real" "$@"