package org.json;

public class XMLParserConfiguration {
   public static final XMLParserConfiguration ORIGINAL = new XMLParserConfiguration();
   public static final XMLParserConfiguration KEEP_STRINGS = new XMLParserConfiguration(true);
   public final boolean keepStrings;
   public final String cDataTagName;
   public final boolean convertNilAttributeToNull;

   public XMLParserConfiguration() {
      this(false, "content", false);
   }

   public XMLParserConfiguration(boolean keepStrings) {
      this(keepStrings, "content", false);
   }

   public XMLParserConfiguration(String cDataTagName) {
      this(false, cDataTagName, false);
   }

   public XMLParserConfiguration(boolean keepStrings, String cDataTagName) {
      this.keepStrings = keepStrings;
      this.cDataTagName = cDataTagName;
      this.convertNilAttributeToNull = false;
   }

   public XMLParserConfiguration(boolean keepStrings, String cDataTagName, boolean convertNilAttributeToNull) {
      this.keepStrings = keepStrings;
      this.cDataTagName = cDataTagName;
      this.convertNilAttributeToNull = convertNilAttributeToNull;
   }
}
