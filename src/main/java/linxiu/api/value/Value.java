/*
 * Decompiled with CFR 0_132.
 */
package linxiu.api.value;

import java.util.function.Supplier;

import com.google.gson.JsonElement;

import linxiu.Client;

public abstract class Value<V> {
	private final String displayName;

	private final String name;
	public V value;

	public float optionAnim = 0;// present
	public float optionAnimNow = 0;// present

	public Value(String displayName, String name) {
		this.displayName = displayName;
		this.name = name;
	}

	public Value(String name) {
		this.displayName = "";
		this.name = name;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public String getName() {
		return name.replaceAll(" ", "");
	}

	public V getValue() {
		return this.value;
	}

	public void setValue(V value) {
		this.value = value;
		if (Client.getINSTANCE().getFileManager() != null)
			Client.getINSTANCE().getFileManager().saveConfig(Client.getINSTANCE().getFileManager().configs);
	}

    public abstract JsonElement toJson();


    public abstract void fromJson(JsonElement element);
    public Supplier<Boolean> displayableFunc = () -> true;

    public Value<V> displayable(Supplier<Boolean> supplier) {
        displayableFunc = supplier;
        return this;
    }

    public Boolean getDisplayableFunc() {
        return displayableFunc.get();
    }
}
