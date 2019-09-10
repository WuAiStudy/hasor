package net.hasor.web.upload;
import net.hasor.test.upload.UploadAction;
import net.hasor.web.WebApiBinder;
import org.junit.Test;

import java.io.File;
import java.util.Map;

public class FileUploadTest extends AbstractFileUploadTest {
    @Test
    public void basic_test_1() throws Exception {
        this.doUploadTest("/fileupload.do", apiBinder -> {
            //
            apiBinder.tryCast(WebApiBinder.class).mappingTo("/fileupload.do").with(UploadAction.class);
        }, (oriData, result) -> {
            //
            ((Map<String, String>) result).forEach((key, hash) -> {
                System.out.println("fileupload key -> " + key);
                Object val = oriData.get(key);
                if (val instanceof byte[]) {
                    assert md5((byte[]) val).equals(hash);
                } else if (val instanceof File) {
                    //
                } else {
                    assert md5(val.toString()).equals(hash);
                }
            });
        });
    }
}