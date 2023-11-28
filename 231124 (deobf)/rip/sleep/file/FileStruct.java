package rip.sleep.file;

import java.io.File;
import java.io.IOException;

public abstract class FileStruct {
   private final File c88411;

   public FileStruct(File var1) {
      this.c88411 = var1;
   }

   protected abstract void c587() throws IOException;

   protected abstract void c61142() throws IOException;

   public void c54284() throws IOException {
      this.c88411.createNewFile();
   }

   public boolean c53181() {
      return this.c88411.exists();
   }

   public File c63704() {
      return this.c88411;
   }
}
