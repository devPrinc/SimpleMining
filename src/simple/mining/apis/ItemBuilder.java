package simple.mining.apis;

import org.bukkit.enchantments.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class ItemBuilder
{
    private ItemStack is;

    public ItemBuilder(final Material m) {
        this(m, 1, (short)0);
    }

    public ItemBuilder(final ItemStack is) {
        this.is = is.clone();
    }

    public ItemBuilder(final Material m, final int amount, final short data) {
        this.is = new ItemStack(m, amount, data);
    }

    public ItemBuilder setName(final String nome) {
        final ItemMeta im = this.is.getItemMeta();
        im.setDisplayName(nome);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemStack toItemStack() {
        return this.is;
    }

    public ItemBuilder setSkullOwner(final String dono) {
        try {
            final SkullMeta im = (SkullMeta)this.is.getItemMeta();
            im.setOwner(dono);
            this.is.setItemMeta((ItemMeta)im);
        }
        catch (Throwable t) {}
        return this;
    }

    public ItemBuilder clone() {
        return new ItemBuilder(this.is);
    }

    public ItemBuilder durability(final int dur) {
        this.is.setDurability((short)dur);
        return this;
    }

    public ItemBuilder name(final String name) {
        final ItemMeta im = this.is.getItemMeta();
        im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder unsafeEnchantment(final Enchantment ench, final int level) {
        this.is.addUnsafeEnchantment(ench, level);
        return this;
    }

    public ItemBuilder enchant(final Enchantment ench, final int level) {
        final ItemMeta im = this.is.getItemMeta();
        im.addEnchant(ench, level, true);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder removeEnchantment(final Enchantment ench) {
        this.is.removeEnchantment(ench);
        return this;
    }

    public ItemBuilder owner(final String owner) {
        try {
            final SkullMeta im = (SkullMeta)this.is.getItemMeta();
            im.setOwner(owner);
            this.is.setItemMeta((ItemMeta)im);
        }
        catch (ClassCastException ex) {}
        return this;
    }

    public ItemBuilder infinityDurabilty() {
        this.is.setDurability((short)32767);
        return this;
    }

    public ItemBuilder lore(final String... lore) {
        final ItemMeta im = this.is.getItemMeta();
        final List<String> out = (im.getLore() == null) ? new ArrayList<String>() : im.getLore();
        for (final String string : lore) {
            out.add(ChatColor.translateAlternateColorCodes('&', string));
        }
        im.setLore((List)out);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder listLore(final List<String> lore) {
        final ItemMeta im = this.is.getItemMeta();
        final List<String> out = (im.getLore() == null) ? new ArrayList<String>() : im.getLore();
        for (final String string : lore) {
            out.add(ChatColor.translateAlternateColorCodes('&', string));
        }
        im.setLore((List)out);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder woolColor(final DyeColor color) {
        if (!this.is.getType().equals((Object)Material.WOOL)) {
            return this;
        }
        this.is.setDurability((short)color.getDyeData());
        return this;
    }

    public ItemBuilder amount(int amount) {
        if (amount > 64) {
            amount = 64;
        }
        this.is.setAmount(amount);
        return this;
    }

    public ItemBuilder removeAttributes() {
        final ItemMeta meta = this.is.getItemMeta();
        meta.addItemFlags(ItemFlag.values());
        this.is.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return this.is;
    }

    public ItemBuilder color(final Color color) {
        if (!this.is.getType().name().contains("LEATHER_")) {
            return this;
        }
        final LeatherArmorMeta meta = (LeatherArmorMeta)this.is.getItemMeta();
        meta.setColor(color);
        this.is.setItemMeta((ItemMeta)meta);
        return this;
    }
}
