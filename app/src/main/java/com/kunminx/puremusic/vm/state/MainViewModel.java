/*
 * Copyright 2018-2020 KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kunminx.puremusic.vm.state;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kunminx.puremusic.data.bean.GridItem;
import com.kunminx.puremusic.domain.request.MusicRequest;
import com.kunminx.puremusic.domain.request.Request;

import java.util.List;

/**
 * Create by KunMinX at 19/10/29
 */
public class MainViewModel extends ViewModel implements Request.IMusicRequest {

    public final ObservableBoolean initTabAndPage = new ObservableBoolean();

    public final ObservableField<String> pageAssetPath = new ObservableField<>();

    public final MutableLiveData<List<GridItem>> javaList = new MutableLiveData<>();
    public final MutableLiveData<List<GridItem>> kotlinList = new MutableLiveData<>();

    private MusicRequest mMusicRequest = new MusicRequest();

    {
        initTabAndPage.set(true);
        pageAssetPath.set("summary.html");
    }

    @Override
    public LiveData<List<GridItem>> getJavaItemsLiveData() {
        return mMusicRequest.getJavaItemsLiveData();
    }

    @Override
    public LiveData<List<GridItem>> getKotlinItemsLiveData() {
        return mMusicRequest.getKotlinItemsLiveData();
    }

    @Override
    public void requestJavaItems() {
        mMusicRequest.requestJavaItems();
    }

    @Override
    public void requestKotlinItems() {
        mMusicRequest.requestKotlinItems();
    }
}