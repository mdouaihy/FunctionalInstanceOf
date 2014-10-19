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

public final class ThenImpl<T> implements Then<T> {

    private final Class<T> tClass;
    private final Object object;
    private final Object computed;

    public ThenImpl(Class<T> tClass, Object object, Object computed) {
        this.tClass = tClass;
        this.object = object;
        this.computed = computed;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R> Chain<R> then(Return<T, R> input) {
        if (computed == null) {
            if (tClass.isAssignableFrom(object.getClass())) {
                return new ChainImpl<>(object, input.evaluate((T) object));
            }
        }
        return new ChainImpl<>(object, (R)computed);
    }

}
