package io.github.haykam821.soulladders.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.haykam821.soulladders.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
	@Shadow
	public abstract BlockState getBlockState();

	@Inject(method = "applyClimbingSpeed", at = @At("RETURN"), cancellable = true)
	public void swiftenSoulLadders(Vec3d original, CallbackInfoReturnable<Vec3d> ci) {
		Block block = this.getBlockState().getBlock();
		if (block.isIn(Main.SOUL_SPEED_CLIMBABLE)) {
			int soulSpeedLevel = EnchantmentHelper.getEquipmentLevel(Enchantments.SOUL_SPEED, (LivingEntity) (Object) this);

			double velocityMultiplier = soulSpeedLevel * 0.3 + 1;
			double clampedY = Math.min(original.getY() * velocityMultiplier, 0.15 * velocityMultiplier);

			ci.setReturnValue(new Vec3d(original.getX(), clampedY * velocityMultiplier, original.getZ()));
		}
	}
}