package linxiu.ui.menu;

import oh.yalan.NativeClass;

@NativeClass
public class Person {
	public boolean check;
	public String code;

	public Person(boolean check, String code) {
		this.check = check;
		this.code = code;
	}
}