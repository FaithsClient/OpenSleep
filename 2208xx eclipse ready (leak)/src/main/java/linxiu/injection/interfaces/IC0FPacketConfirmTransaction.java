package linxiu.injection.interfaces;

public interface IC0FPacketConfirmTransaction {

	void setwindowId(int b);

	int getwindowID();

	void setAccepted(boolean b);

	void setUid(short b);

	short getUid();

	boolean getAccepted();

}
