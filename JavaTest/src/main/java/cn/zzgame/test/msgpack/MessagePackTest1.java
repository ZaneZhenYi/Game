package cn.zzgame.test.msgpack;

import java.io.IOException;

import org.msgpack.MessagePack;
import org.msgpack.type.Value;
	
public class MessagePackTest1 {
	public static void main(String[] args) throws IOException {
		MessagePack msgPack = new MessagePack();
		DefaultMessagePack rsp = new DefaultMessagePack();
		rsp.setId(10);
		rsp.setException(null);
		rsp.setReturnObject(null);
		byte[] data = msgPack.write(rsp);
		
		Value v = msgPack.read(data);
		Value[] vs = v.asArrayValue().getElementArray();
		long id = vs[0].asIntegerValue().getLong();
		String exception = null;
		if(vs[1] != null && ! vs[1].isNilValue()){
			exception = vs[1].asRawValue().getString();
		}
		Object returnObject = vs[2];
		DefaultMessagePack rsp2 = new DefaultMessagePack();
		rsp2.setId(id);
		rsp2.setException(exception);
		rsp2.setReturnObject(returnObject);
		
		System.out.println(rsp2);
	}
}
