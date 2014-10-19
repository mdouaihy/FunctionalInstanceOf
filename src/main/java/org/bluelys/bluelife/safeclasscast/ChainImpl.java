/*
 * Copyright 2014 Mehrez DOUAIHY
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bluelys.bluelife.safeclasscast;


public final class ChainImpl<R> implements Chain<R> {
    private final Object object;
    private final R computed;

    public ChainImpl(Object object, R computed) {
        this.object = object;
        this.computed = computed;
    }

    public <T> Then<T> elseof(Class<T> tClass) {
        return new ThenImpl<>(tClass, object, computed);
    }

    @Override
    public R value() {
        if (computed == null) {
            throw new IllegalStateException("No adequate code was found for " + object.getClass().getName() + ".");
        }
        return computed;
    }

    @Override
    public R otherwise(R value) {
        return computed != null ? computed : value;
    }

    @Override
    public R otherwise(Return<Object, R> returnE) {
        return computed != null ? computed : returnE.evaluate(object);
    }
}
