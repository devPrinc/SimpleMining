package simple.mining.particles;

import simple.mining.particles.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public enum ParticleEffect {
    EXPLOSION_NORMAL("EXPLOSION_NORMAL", 0, "EXPLOSION_NORMAL", 0, "EXPLOSION_NORMAL", 0, "explode", 0, -1, ParticleProperty.DIRECTIONAL),
    EXPLOSION_LARGE("EXPLOSION_LARGE", 1, "EXPLOSION_LARGE", 1, "EXPLOSION_LARGE", 1, "largeexplode", 1, -1, new ParticleProperty[0]),
    EXPLOSION_HUGE("EXPLOSION_HUGE", 2, "EXPLOSION_HUGE", 2, "EXPLOSION_HUGE", 2, "hugeexplosion", 2, -1, new ParticleProperty[0]),
    FIREWORKS_SPARK("FIREWORKS_SPARK", 3, "FIREWORKS_SPARK", 3, "FIREWORKS_SPARK", 3, "fireworksSpark", 3, -1, ParticleProperty.DIRECTIONAL),
    WATER_BUBBLE("WATER_BUBBLE", 4, "WATER_BUBBLE", 4, "WATER_BUBBLE", 4, "bubble", 4, -1, ParticleProperty.DIRECTIONAL, ParticleProperty.REQUIRES_WATER),
    WATER_SPLASH("WATER_SPLASH", 5, "WATER_SPLASH", 5, "WATER_SPLASH", 5, "splash", 5, -1, ParticleProperty.DIRECTIONAL),
    WATER_WAKE("WATER_WAKE", 6, "WATER_WAKE", 6, "WATER_WAKE", 6, "wake", 6, 7, ParticleProperty.DIRECTIONAL),
    SUSPENDED("SUSPENDED", 7, "SUSPENDED", 7, "SUSPENDED", 7, "suspended", 7, -1, ParticleProperty.REQUIRES_WATER),
    SUSPENDED_DEPTH("SUSPENDED_DEPTH", 8, "SUSPENDED_DEPTH", 8, "SUSPENDED_DEPTH", 8, "depthSuspend", 8, -1, ParticleProperty.DIRECTIONAL),
    CRIT("CRIT", 9, "CRIT", 9, "CRIT", 9, "crit", 9, -1, ParticleProperty.DIRECTIONAL),
    CRIT_MAGIC("CRIT_MAGIC", 10, "CRIT_MAGIC", 10, "CRIT_MAGIC", 10, "magicCrit", 10, -1, ParticleProperty.DIRECTIONAL),
    SMOKE_NORMAL("SMOKE_NORMAL", 11, "SMOKE_NORMAL", 11, "SMOKE_NORMAL", 11, "smoke", 11, -1, ParticleProperty.DIRECTIONAL),
    SMOKE_LARGE("SMOKE_LARGE", 12, "SMOKE_LARGE", 12, "SMOKE_LARGE", 12, "largesmoke", 12, -1, ParticleProperty.DIRECTIONAL),
    SPELL("SPELL", 13, "SPELL", 13, "SPELL", 13, "spell", 13, -1, new ParticleProperty[0]),
    SPELL_INSTANT("SPELL_INSTANT", 14, "SPELL_INSTANT", 14, "SPELL_INSTANT", 14, "instantSpell", 14, -1, new ParticleProperty[0]),
    SPELL_MOB("SPELL_MOB", 15, "SPELL_MOB", 15, "SPELL_MOB", 15, "mobSpell", 15, -1, ParticleProperty.COLORABLE),
    SPELL_MOB_AMBIENT("SPELL_MOB_AMBIENT", 16, "SPELL_MOB_AMBIENT", 16, "SPELL_MOB_AMBIENT", 16, "mobSpellAmbient", 16, -1, ParticleProperty.COLORABLE),
    SPELL_WITCH("SPELL_WITCH", 17, "SPELL_WITCH", 17, "SPELL_WITCH", 17, "witchMagic", 17, -1, new ParticleProperty[0]),
    DRIP_WATER("DRIP_WATER", 18, "DRIP_WATER", 18, "DRIP_WATER", 18, "dripWater", 18, -1, new ParticleProperty[0]),
    DRIP_LAVA("DRIP_LAVA", 19, "DRIP_LAVA", 19, "DRIP_LAVA", 19, "dripLava", 19, -1, new ParticleProperty[0]),
    VILLAGER_ANGRY("VILLAGER_ANGRY", 20, "VILLAGER_ANGRY", 20, "VILLAGER_ANGRY", 20, "angryVillager", 20, -1, new ParticleProperty[0]),
    VILLAGER_HAPPY("VILLAGER_HAPPY", 21, "VILLAGER_HAPPY", 21, "VILLAGER_HAPPY", 21, "happyVillager", 21, -1, ParticleProperty.DIRECTIONAL),
    TOWN_AURA("TOWN_AURA", 22, "TOWN_AURA", 22, "TOWN_AURA", 22, "townaura", 22, -1, ParticleProperty.DIRECTIONAL),
    NOTE("NOTE", 23, "NOTE", 23, "NOTE", 23, "note", 23, -1, ParticleProperty.COLORABLE),
    PORTAL("PORTAL", 24, "PORTAL", 24, "PORTAL", 24, "portal", 24, -1, ParticleProperty.DIRECTIONAL),
    ENCHANTMENT_TABLE("ENCHANTMENT_TABLE", 25, "ENCHANTMENT_TABLE", 25, "ENCHANTMENT_TABLE", 25, "enchantmenttable", 25, -1, ParticleProperty.DIRECTIONAL),
    FLAME("FLAME", 26, "FLAME", 26, "FLAME", 26, "flame", 26, -1, ParticleProperty.DIRECTIONAL),
    LAVA("LAVA", 27, "LAVA", 27, "LAVA", 27, "lava", 27, -1, new ParticleProperty[0]),
    FOOTSTEP("FOOTSTEP", 28, "FOOTSTEP", 28, "FOOTSTEP", 28, "footstep", 28, -1, new ParticleProperty[0]),
    CLOUD("CLOUD", 29, "CLOUD", 29, "CLOUD", 29, "cloud", 29, -1, ParticleProperty.DIRECTIONAL),
    REDSTONE("REDSTONE", 30, "REDSTONE", 30, "REDSTONE", 30, "reddust", 30, -1, ParticleProperty.COLORABLE),
    SNOWBALL("SNOWBALL", 31, "SNOWBALL", 31, "SNOWBALL", 31, "snowballpoof", 31, -1, new ParticleProperty[0]),
    SNOW_SHOVEL("SNOW_SHOVEL", 32, "SNOW_SHOVEL", 32, "SNOW_SHOVEL", 32, "snowshovel", 32, -1, ParticleProperty.DIRECTIONAL),
    SLIME("SLIME", 33, "SLIME", 33, "SLIME", 33, "slime", 33, -1, new ParticleProperty[0]),
    HEART("HEART", 34, "HEART", 34, "HEART", 34, "heart", 34, -1, new ParticleProperty[0]),
    BARRIER("BARRIER", 35, "BARRIER", 35, "BARRIER", 35, "barrier", 35, 8, new ParticleProperty[0]),
    ITEM_CRACK("ITEM_CRACK", 36, "ITEM_CRACK", 36, "ITEM_CRACK", 36, "iconcrack", 36, -1, ParticleProperty.DIRECTIONAL, ParticleProperty.REQUIRES_DATA),
    BLOCK_CRACK("BLOCK_CRACK", 37, "BLOCK_CRACK", 37, "BLOCK_CRACK", 37, "blockcrack", 37, -1, ParticleProperty.DIRECTIONAL, ParticleProperty.REQUIRES_DATA),
    BLOCK_DUST("BLOCK_DUST", 38, "BLOCK_DUST", 38, "BLOCK_DUST", 38, "blockdust", 38, 7, ParticleProperty.DIRECTIONAL, ParticleProperty.REQUIRES_DATA),
    WATER_DROP("WATER_DROP", 39, "WATER_DROP", 39, "WATER_DROP", 39, "droplet", 39, 8, new ParticleProperty[0]),
    ITEM_TAKE("ITEM_TAKE", 40, "ITEM_TAKE", 40, "ITEM_TAKE", 40, "take", 40, 8, new ParticleProperty[0]),
    MOB_APPEARANCE("MOB_APPEARANCE", 41, "MOB_APPEARANCE", 41, "MOB_APPEARANCE", 41, "mobappearance", 41, 8, new ParticleProperty[0]);

    private static final Map<String, ParticleEffect> NAME_MAP;
    private static final Map<Integer, ParticleEffect> ID_MAP;
    private final String name;
    private final int id;
    private final int requiredVersion;
    private final List<ParticleProperty> properties;

    private ParticleEffect(String s3, int n3, String s2, int n2, String s, int n4, String name, int id, int requiredVersion, ParticleProperty ... properties) {
        this.name = name;
        this.id = id;
        this.requiredVersion = requiredVersion;
        this.properties = Arrays.asList(properties);
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getRequiredVersion() {
        return this.requiredVersion;
    }

    public boolean hasProperty(ParticleProperty property) {
        return this.properties.contains((Object)property);
    }

    public boolean isSupported() {
        return this.requiredVersion == -1 || ParticlePacket.getVersion() >= this.requiredVersion;
    }

    public static ParticleEffect fromName(String name) {
        for (Map.Entry<String, ParticleEffect> entry : NAME_MAP.entrySet()) {
            if (!entry.getKey().equalsIgnoreCase(name)) continue;
            return entry.getValue();
        }
        return null;
    }

    public static ParticleEffect fromId(int id) {
        for (Map.Entry<Integer, ParticleEffect> entry : ID_MAP.entrySet()) {
            if (entry.getKey() != id) continue;
            return entry.getValue();
        }
        return null;
    }

    private static boolean isWater(Location location) {
        Material material = location.getBlock().getType();
        return material == Material.WATER || material == Material.STATIONARY_WATER;
    }

    private static boolean isLongDistance(Location location, List<Player> players) {
        for (Player player : players) {
            if (player.getLocation().distanceSquared(location) < 65536.0) continue;
            return true;
        }
        return false;
    }

    private static boolean isDataCorrect(ParticleEffect effect, ParticleData data) {
        return (effect == BLOCK_CRACK || effect == BLOCK_DUST) && data instanceof BlockData || effect == ITEM_CRACK && data instanceof ItemData;
    }

    private static boolean isColorCorrect(ParticleEffect effect, ParticleColor color) {
        return (effect == SPELL_MOB || effect == SPELL_MOB_AMBIENT || effect == REDSTONE) && color instanceof OrdinaryColor || effect == NOTE && color instanceof NoteColor;
    }

    public void display(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, double range) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("This particle effect is not supported by your server version");
        }
        if (this.hasProperty(ParticleProperty.REQUIRES_DATA)) {
            throw new ParticleDataException("This particle effect requires additional data");
        }
        if (this.hasProperty(ParticleProperty.REQUIRES_WATER) && !ParticleEffect.isWater(center)) {
            throw new IllegalArgumentException("There is no water at the center location");
        }
        new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, range > 256.0, null).sendTo(center, range);
    }

    public void display(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, List<Player> players) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("This particle effect is not supported by your server version");
        }
        if (this.hasProperty(ParticleProperty.REQUIRES_DATA)) {
            throw new ParticleDataException("This particle effect requires additional data");
        }
        if (this.hasProperty(ParticleProperty.REQUIRES_WATER) && !ParticleEffect.isWater(center)) {
            throw new IllegalArgumentException("There is no water at the center location");
        }
        new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, ParticleEffect.isLongDistance(center, players), null).sendTo(center, players);
    }

    public void display(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, Player ... players) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
        this.display(offsetX, offsetY, offsetZ, speed, amount, center, Arrays.asList(players));
    }

    public void display(Vector direction, float speed, Location center, double range) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("This particle effect is not supported by your server version");
        }
        if (this.hasProperty(ParticleProperty.REQUIRES_DATA)) {
            throw new ParticleDataException("This particle effect requires additional data");
        }
        if (!this.hasProperty(ParticleProperty.DIRECTIONAL)) {
            throw new IllegalArgumentException("This particle effect is not directional");
        }
        if (this.hasProperty(ParticleProperty.REQUIRES_WATER) && !ParticleEffect.isWater(center)) {
            throw new IllegalArgumentException("There is no water at the center location");
        }
        new ParticlePacket(this, direction, speed, range > 256.0, null).sendTo(center, range);
    }

    public void display(Vector direction, float speed, Location center, List<Player> players) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("This particle effect is not supported by your server version");
        }
        if (this.hasProperty(ParticleProperty.REQUIRES_DATA)) {
            throw new ParticleDataException("This particle effect requires additional data");
        }
        if (!this.hasProperty(ParticleProperty.DIRECTIONAL)) {
            throw new IllegalArgumentException("This particle effect is not directional");
        }
        if (this.hasProperty(ParticleProperty.REQUIRES_WATER) && !ParticleEffect.isWater(center)) {
            throw new IllegalArgumentException("There is no water at the center location");
        }
        new ParticlePacket(this, direction, speed, ParticleEffect.isLongDistance(center, players), null).sendTo(center, players);
    }

    public void display(Vector direction, float speed, Location center, Player ... players) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
        this.display(direction, speed, center, Arrays.asList(players));
    }

    public void display(ParticleColor color, Location center, double range) throws ParticleVersionException, ParticleColorException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("This particle effect is not supported by your server version");
        }
        if (!this.hasProperty(ParticleProperty.COLORABLE)) {
            throw new ParticleColorException("This particle effect is not colorable");
        }
        if (!ParticleEffect.isColorCorrect(this, color)) {
            throw new ParticleColorException("The particle color type is incorrect");
        }
        new ParticlePacket(this, color, range > 256.0).sendTo(center, range);
    }

    public void display(ParticleColor color, Location center, List<Player> players) throws ParticleVersionException, ParticleColorException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("This particle effect is not supported by your server version");
        }
        if (!this.hasProperty(ParticleProperty.COLORABLE)) {
            throw new ParticleColorException("This particle effect is not colorable");
        }
        if (!ParticleEffect.isColorCorrect(this, color)) {
            throw new ParticleColorException("The particle color type is incorrect");
        }
        new ParticlePacket(this, color, ParticleEffect.isLongDistance(center, players)).sendTo(center, players);
    }

    public void display(ParticleColor color, Location center, Player ... players) throws ParticleVersionException, ParticleColorException {
        this.display(color, center, Arrays.asList(players));
    }

    public void display(ParticleData data, float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, double range) throws ParticleVersionException, ParticleDataException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("This particle effect is not supported by your server version");
        }
        if (!this.hasProperty(ParticleProperty.REQUIRES_DATA)) {
            throw new ParticleDataException("This particle effect does not require additional data");
        }
        if (!ParticleEffect.isDataCorrect(this, data)) {
            throw new ParticleDataException("The particle data type is incorrect");
        }
        new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, range > 256.0, data).sendTo(center, range);
    }

    public void display(ParticleData data, float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, List<Player> players) throws ParticleVersionException, ParticleDataException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("This particle effect is not supported by your server version");
        }
        if (!this.hasProperty(ParticleProperty.REQUIRES_DATA)) {
            throw new ParticleDataException("This particle effect does not require additional data");
        }
        if (!ParticleEffect.isDataCorrect(this, data)) {
            throw new ParticleDataException("The particle data type is incorrect");
        }
        new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, ParticleEffect.isLongDistance(center, players), data).sendTo(center, players);
    }

    public void display(ParticleData data, float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, Player ... players) throws ParticleVersionException, ParticleDataException {
        this.display(data, offsetX, offsetY, offsetZ, speed, amount, center, Arrays.asList(players));
    }

    public void display(ParticleData data, Vector direction, float speed, Location center, double range) throws ParticleVersionException, ParticleDataException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("This particle effect is not supported by your server version");
        }
        if (!this.hasProperty(ParticleProperty.REQUIRES_DATA)) {
            throw new ParticleDataException("This particle effect does not require additional data");
        }
        if (!ParticleEffect.isDataCorrect(this, data)) {
            throw new ParticleDataException("The particle data type is incorrect");
        }
        new ParticlePacket(this, direction, speed, range > 256.0, data).sendTo(center, range);
    }

    public void display(ParticleData data, Vector direction, float speed, Location center, List<Player> players) throws ParticleVersionException, ParticleDataException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("This particle effect is not supported by your server version");
        }
        if (!this.hasProperty(ParticleProperty.REQUIRES_DATA)) {
            throw new ParticleDataException("This particle effect does not require additional data");
        }
        if (!ParticleEffect.isDataCorrect(this, data)) {
            throw new ParticleDataException("The particle data type is incorrect");
        }
        new ParticlePacket(this, direction, speed, ParticleEffect.isLongDistance(center, players), data).sendTo(center, players);
    }

    public void display(ParticleData data, Vector direction, float speed, Location center, Player ... players) throws ParticleVersionException, ParticleDataException {
        this.display(data, direction, speed, center, Arrays.asList(players));
    }

    static {
        NAME_MAP = new HashMap<String, ParticleEffect>();
        ID_MAP = new HashMap<Integer, ParticleEffect>();
        for (ParticleEffect effect : ParticleEffect.values()) {
            NAME_MAP.put(effect.name, effect);
            ID_MAP.put(effect.id, effect);
        }
    }

    public static final class ParticlePacket {
        private static int version;
        private static Class<?> enumParticle;
        private static Constructor<?> packetConstructor;
        private static Method getHandle;
        private static Field playerConnection;
        private static Method sendPacket;
        private static boolean initialized;
        private final ParticleEffect effect;
        private final float offsetX;
        private final float offsetY;
        private final float offsetZ;
        private final float speed;
        private final int amount;
        private final boolean longDistance;
        private final ParticleData data;
        private Object packet;

        public ParticlePacket(ParticleEffect effect, float offsetX, float offsetY, float offsetZ, float speed, int amount, boolean longDistance, ParticleData data) throws IllegalArgumentException {
            ParticlePacket.initialize();
            if (speed < 0.0f) {
                throw new IllegalArgumentException("The speed is lower than 0");
            }
            if (amount < 0) {
                throw new IllegalArgumentException("The amount is lower than 0");
            }
            this.effect = effect;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.offsetZ = offsetZ;
            this.speed = speed;
            this.amount = amount;
            this.longDistance = longDistance;
            this.data = data;
        }

        public ParticlePacket(ParticleEffect effect, Vector direction, float speed, boolean longDistance, ParticleData data) throws IllegalArgumentException {
            this(effect, (float)direction.getX(), (float)direction.getY(), (float)direction.getZ(), speed, 0, longDistance, data);
        }

        public ParticlePacket(ParticleEffect effect, ParticleColor color, boolean longDistance) {
            this(effect, color.getValueX(), color.getValueY(), color.getValueZ(), 1.0f, 0, longDistance, null);
        }

        public static void initialize() throws VersionIncompatibleException {
            if (initialized) {
                return;
            }
            try {
                version = Integer.parseInt(Character.toString(ReflectionUtils.PackageType.getServerVersion().charAt(3)));
                if (version > 7) {
                    enumParticle = ReflectionUtils.PackageType.MINECRAFT_SERVER.getClass("EnumParticle");
                }
                Class<?> packetClass = ReflectionUtils.PackageType.MINECRAFT_SERVER.getClass(version < 7 ? "Packet63WorldParticles" : "PacketPlayOutWorldParticles");
                packetConstructor = ReflectionUtils.getConstructor(packetClass, new Class[0]);
                getHandle = ReflectionUtils.getMethod("CraftPlayer", ReflectionUtils.PackageType.CRAFTBUKKIT_ENTITY, "getHandle", new Class[0]);
                playerConnection = ReflectionUtils.getField("EntityPlayer", ReflectionUtils.PackageType.MINECRAFT_SERVER, false, "playerConnection");
                sendPacket = ReflectionUtils.getMethod(playerConnection.getType(), "sendPacket", ReflectionUtils.PackageType.MINECRAFT_SERVER.getClass("Packet"));
            }
            catch (Exception exception) {
                throw new VersionIncompatibleException("Your current bukkit version seems to be incompatible with this library", exception);
            }
            initialized = true;
        }

        public static int getVersion() {
            return version;
        }

        public static boolean isInitialized() {
            return initialized;
        }

        private void initializePacket(Location center) throws PacketInstantiationException {
            if (this.packet != null) {
                return;
            }
            try {
                this.packet = packetConstructor.newInstance(new Object[0]);
                if (version < 8) {
                    String name = this.effect.getName();
                    if (this.data != null) {
                        name = String.valueOf(String.valueOf(String.valueOf(name))) + this.data.getPacketDataString();
                    }
                    ReflectionUtils.setValue(this.packet, true, "a", name);
                } else {
                    ReflectionUtils.setValue(this.packet, true, "a", enumParticle.getEnumConstants()[this.effect.getId()]);
                    ReflectionUtils.setValue(this.packet, true, "j", this.longDistance);
                    if (this.data != null) {
                        ReflectionUtils.setValue(this.packet, true, "k", this.data.getPacketData());
                    }
                }
                ReflectionUtils.setValue(this.packet, true, "b", Float.valueOf((float)center.getX()));
                ReflectionUtils.setValue(this.packet, true, "c", Float.valueOf((float)center.getY()));
                ReflectionUtils.setValue(this.packet, true, "d", Float.valueOf((float)center.getZ()));
                ReflectionUtils.setValue(this.packet, true, "e", Float.valueOf(this.offsetX));
                ReflectionUtils.setValue(this.packet, true, "f", Float.valueOf(this.offsetY));
                ReflectionUtils.setValue(this.packet, true, "g", Float.valueOf(this.offsetZ));
                ReflectionUtils.setValue(this.packet, true, "h", Float.valueOf(this.speed));
                ReflectionUtils.setValue(this.packet, true, "i", this.amount);
            }
            catch (Exception exception) {
                throw new PacketInstantiationException("Packet instantiation failed", exception);
            }
        }

        public void sendTo(Location center, Player player) throws PacketInstantiationException, PacketSendingException {
            this.initializePacket(center);
            try {
                sendPacket.invoke(playerConnection.get(getHandle.invoke(player, new Object[0])), this.packet);
            }
            catch (Exception exception) {
                throw new PacketSendingException("Failed to send the packet to player '" + player.getName() + "'", exception);
            }
        }

        public void sendTo(Location center, List<Player> players) throws IllegalArgumentException {
            if (players.isEmpty()) {
                throw new IllegalArgumentException("The player list is empty");
            }
            for (Player player : players) {
                this.sendTo(center, player);
            }
        }

        public void sendTo(Location center, double range) throws IllegalArgumentException {
            if (range < 1.0) {
                throw new IllegalArgumentException("The range is lower than 1");
            }
            String worldName = center.getWorld().getName();
            double squared = range * range;
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!player.getWorld().getName().equals(worldName) || player.getLocation().distanceSquared(center) > squared) continue;
                this.sendTo(center, player);
            }
        }

        private static final class PacketSendingException
                extends RuntimeException {
            private static final long serialVersionUID = 3203085387160737484L;

            public PacketSendingException(String message, Throwable cause) {
                super(message, cause);
            }
        }

        private static final class PacketInstantiationException
                extends RuntimeException {
            private static final long serialVersionUID = 3203085387160737484L;

            public PacketInstantiationException(String message, Throwable cause) {
                super(message, cause);
            }
        }

        private static final class VersionIncompatibleException
                extends RuntimeException {
            private static final long serialVersionUID = 3203085387160737484L;

            public VersionIncompatibleException(String message, Throwable cause) {
                super(message, cause);
            }
        }
    }

    private static final class ParticleVersionException
            extends RuntimeException {
        private static final long serialVersionUID = 3203085387160737484L;

        public ParticleVersionException(String message) {
            super(message);
        }
    }

    private static final class ParticleColorException
            extends RuntimeException {
        private static final long serialVersionUID = 3203085387160737484L;

        public ParticleColorException(String message) {
            super(message);
        }
    }

    private static final class ParticleDataException
            extends RuntimeException {
        private static final long serialVersionUID = 3203085387160737484L;

        public ParticleDataException(String message) {
            super(message);
        }
    }

    public static final class NoteColor
            extends ParticleColor {
        private final int note;

        public NoteColor(int note) throws IllegalArgumentException {
            if (note < 0) {
                throw new IllegalArgumentException("The note value is lower than 0");
            }
            if (note > 24) {
                throw new IllegalArgumentException("The note value is higher than 24");
            }
            this.note = note;
        }

        @Override
        public float getValueX() {
            return (float)this.note / 24.0f;
        }

        @Override
        public float getValueY() {
            return 0.0f;
        }

        @Override
        public float getValueZ() {
            return 0.0f;
        }
    }

    public static final class OrdinaryColor
            extends ParticleColor {
        private final int red;
        private final int green;
        private final int blue;

        public OrdinaryColor(int red, int green, int blue) throws IllegalArgumentException {
            if (red < 0) {
                throw new IllegalArgumentException("The red value is lower than 0");
            }
            if (red > 255) {
                throw new IllegalArgumentException("The red value is higher than 255");
            }
            this.red = red;
            if (green < 0) {
                throw new IllegalArgumentException("The green value is lower than 0");
            }
            if (green > 255) {
                throw new IllegalArgumentException("The green value is higher than 255");
            }
            this.green = green;
            if (blue < 0) {
                throw new IllegalArgumentException("The blue value is lower than 0");
            }
            if (blue > 255) {
                throw new IllegalArgumentException("The blue value is higher than 255");
            }
            this.blue = blue;
        }

        public int getRed() {
            return this.red;
        }

        public int getGreen() {
            return this.green;
        }

        public int getBlue() {
            return this.blue;
        }

        @Override
        public float getValueX() {
            return (float)this.red / 255.0f;
        }

        @Override
        public float getValueY() {
            return (float)this.green / 255.0f;
        }

        @Override
        public float getValueZ() {
            return (float)this.blue / 255.0f;
        }
    }

    public static abstract class ParticleColor {
        public abstract float getValueX();

        public abstract float getValueY();

        public abstract float getValueZ();
    }

    public static final class BlockData
            extends ParticleData {
        public BlockData(Material material, byte data) throws IllegalArgumentException {
            super(material, data);
            if (!material.isBlock()) {
                throw new IllegalArgumentException("The material is not a block");
            }
        }
    }

    public static final class ItemData
            extends ParticleData {
        public ItemData(Material material, byte data) {
            super(material, data);
        }
    }

    public static abstract class ParticleData {
        private final Material material;
        private final byte data;
        private final int[] packetData;

        public ParticleData(Material material, byte data) {
            this.material = material;
            this.data = data;
            this.packetData = new int[]{material.getId(), data};
        }

        public Material getMaterial() {
            return this.material;
        }

        public byte getData() {
            return this.data;
        }

        public int[] getPacketData() {
            return this.packetData;
        }

        public String getPacketDataString() {
            return "_" + this.packetData[0] + "_" + this.packetData[1];
        }
    }

    public static enum ParticleProperty {
        REQUIRES_WATER("REQUIRES_WATER", 0, "REQUIRES_WATER", 0, "REQUIRES_WATER", 0),
        REQUIRES_DATA("REQUIRES_DATA", 1, "REQUIRES_DATA", 1, "REQUIRES_DATA", 1),
        DIRECTIONAL("DIRECTIONAL", 2, "DIRECTIONAL", 2, "DIRECTIONAL", 2),
        COLORABLE("COLORABLE", 3, "COLORABLE", 3, "COLORABLE", 3);


        private ParticleProperty(String s3, int n3, String s2, int n2, String s, int n4) {
        }
    }
}
