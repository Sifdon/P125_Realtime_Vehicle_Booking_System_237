/*
 *  Copyright(c) 2017 lizhaotailang
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

package io.github.marktony.espresso.data;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by lizhaotailang on 2017/2/23.
 * Immutable model class for a Company.
 * JSON format sample
 * {
 * ‘name’:'EMS',
 * 'id':'ems',
 * 'tel':'11183',
 * 'website':'http://www.ems.com.cn/',
 * 'alphabet':'ems',
 * 'avatar': '#009688'
 * }
 *
 */

public class Company extends RealmObject {

    @Expose
    @SerializedName("name")
    private String name;

    @PrimaryKey
    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("tel")
    private String tel;

    @Expose
    @SerializedName("website")
    private String website;

    @Expose
    @SerializedName("alphabet")
    private String alphabet;

    @Expose
    @SerializedName("avatar")
    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getAvatarColor() {
        return avatar;
    }

    public void setAvatarColor(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
