package cn.artern.tools.MD5;

import cn.artern.tools.Interface.SecString;
import cn.artern.tools.nativeSource.GetPhysicalAddress;
import cn.artern.tools.String.MixStringWithoutSame;

public class SecStringImpFromPhysicalAddress implements SecString {

	public String toString() {
		return MixStringWithoutSame.execute(GetPhysicalAddress.execute(),
				"0123456789ABCDEF");
	}

}
