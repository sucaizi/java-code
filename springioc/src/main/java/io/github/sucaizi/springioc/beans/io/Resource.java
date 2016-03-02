package io.github.sucaizi.springioc.beans.io;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {

	InputStream getInputStream() throws IOException;
}
