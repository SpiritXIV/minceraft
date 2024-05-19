package com.spirit.koil.accessor;

public interface LivingEntityAccessor
{
	boolean punch();
	boolean IsPunching();
	boolean IsUsing();
	void addRecoil(float recoil);
	
	float getRecoil();

	float getPunchProgress(float tickDelta);
}