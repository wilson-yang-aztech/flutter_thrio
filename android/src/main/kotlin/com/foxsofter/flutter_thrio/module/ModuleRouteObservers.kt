/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 foxsofter
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

package com.foxsofter.flutter_thrio.module

import com.foxsofter.flutter_thrio.navigator.FlutterEngineFactory
import com.foxsofter.flutter_thrio.navigator.Log
import com.foxsofter.flutter_thrio.navigator.RouteObserver
import com.foxsofter.flutter_thrio.navigator.RouteSettings
import com.foxsofter.flutter_thrio.registry.RegistrySet

internal object ModuleRouteObservers : RouteObserver {
    private const val TAG = "RouteObservers"

    val observers by lazy { RegistrySet<RouteObserver>() }

    init {
        observers.registry(FlutterEngineFactory)
    }

    override fun didPush(routeSettings: RouteSettings) {
        Log.i(
            TAG, "didPush: url->${routeSettings.url} " +
                    "index->${routeSettings.index} "
        )
        observers.forEach {
            it.didPush(routeSettings)
        }
    }

    override fun didPop(routeSettings: RouteSettings) {
        Log.i(
            TAG, "didPop: url->${routeSettings.url} " +
                    "index->${routeSettings.index} "
        )
        observers.forEach {
            it.didPop(routeSettings)
        }
    }

    override fun didPopTo(routeSettings: RouteSettings) {
        Log.i(
            TAG, "didPopTo: url->${routeSettings.url} " +
                    "index->${routeSettings.index} "
        )
        observers.forEach {
            it.didPopTo(routeSettings)
        }
    }

    override fun didRemove(routeSettings: RouteSettings) {
        Log.i(
            TAG, "didRemove: url->${routeSettings.url} " +
                    "index->${routeSettings.index} "
        )
        observers.forEach {
            it.didRemove(routeSettings)
        }
    }

    override fun didReplace(newRouteSettings: RouteSettings, oldRouteSettings: RouteSettings) {
        Log.i(
            TAG, "didReplace:url->${oldRouteSettings.url} index->${oldRouteSettings.index}"
        + " newUrl->${newRouteSettings.url} newIndex->${newRouteSettings.index}"
        )
        observers.forEach {
            it.didReplace(newRouteSettings, oldRouteSettings)
        }
    }
}