/*
 * Copyright 2008-2009 the original 赵永春(zyc@hasor.net).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.demo.hasor.web.history;
import net.demo.hasor.manager.VersionInfoManager;
import net.hasor.core.Inject;
import net.hasor.plugins.restful.WebController;
import net.hasor.plugins.restful.api.MappingTo;
/**
 * 
 * @version : 2016年1月1日
 * @author 赵永春(zyc@hasor.net)
 */
@MappingTo("/history/index.htm")
public class Index extends WebController {
    @Inject
    private VersionInfoManager versionInfoManager;
    //
    public void execute() {
        getContextMap().put("versionMap", this.versionInfoManager);
    }
}