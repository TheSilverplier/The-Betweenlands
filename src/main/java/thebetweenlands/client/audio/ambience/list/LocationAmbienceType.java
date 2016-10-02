package thebetweenlands.client.audio.ambience.list;

import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import thebetweenlands.client.audio.ambience.AmbienceLayer;
import thebetweenlands.client.audio.ambience.AmbienceType;
import thebetweenlands.common.registries.AmbienceRegistry;
import thebetweenlands.common.world.storage.chunk.storage.locationold.LocationAmbience;
import thebetweenlands.common.world.storage.chunk.storage.locationold.LocationStorage;
import thebetweenlands.common.world.storage.chunk.storage.locationold.LocationAmbience.EnumLocationAmbience;

public class LocationAmbienceType extends AmbienceType {
	private final EnumLocationAmbience ambience;
	private final SoundEvent sound;

	public LocationAmbienceType(EnumLocationAmbience ambience, SoundEvent sound) {
		this.ambience = ambience;
		this.sound = sound;
	}

	protected LocationAmbience getAmbience() {
		return LocationStorage.getAmbience(this.getPlayer());
	}

	@Override
	public boolean isActive() {
		return this.getAmbience() != null && this.getAmbience().type == this.ambience;
	}

	@Override
	public AmbienceLayer getAmbienceLayer() {
		return AmbienceRegistry.BASE_LAYER;
	}

	@Override
	public int getPriority() {
		return 5;
	}

	@Override
	public boolean stopsMusic() {
		return true;
	}

	@Override
	public SoundCategory getCategory() {
		return SoundCategory.AMBIENT;
	}

	@Override
	public SoundEvent getSound() {
		return this.sound;
	}
}
