package cn.zzgame.test.msgpack;

import java.io.IOException;

import org.msgpack.MessagePackable;
import org.msgpack.packer.Packer;
import org.msgpack.unpacker.Unpacker;

public class DefaultMessagePack implements MessagePackable {

	private long id;
	private String exception;
	private Object returnObject;
	
	@Override
	public void writeTo(Packer pk) throws IOException {
		pk.writeArrayBegin(3);
		pk.write(id);
		pk.write(returnObject);
		pk.write(exception);
		pk.writeArrayEnd();
	}

	@Override
	public void readFrom(Unpacker u) throws IOException {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public Object getReturnObject() {
		return returnObject;
	}

	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

	@Override
	public String toString() {
		return "DefaultMessagePack [id=" + id + ", exception=" + exception + ", returnObject=" + returnObject + "]";
	}
	
}
