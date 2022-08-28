package simple.mining.apis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import simple.mining.inicializer.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class UltimateFancy {
    private ChatColor lastColor = ChatColor.WHITE;
    private JSONArray constructor = new JSONArray();
    private HashMap<String, Boolean> lastformats;
    private List<JSONObject> workingGroup = new ArrayList<JSONObject>();
    private List<ExtraElement> pendentElements;

    public UltimateFancy() {
        this.lastformats = new HashMap();
        this.pendentElements = new ArrayList<ExtraElement>();
    }

    public UltimateFancy(String text) {
        this.lastformats = new HashMap();
        this.pendentElements = new ArrayList<ExtraElement>();
        this.text(text);
    }

    public UltimateFancy text(String text) {
        for (String part : text.split("(?=§)")) {
            JSONObject workingText = new JSONObject();
            this.filterColors(workingText);
            Matcher match = Pattern.compile("^§([0-9a-fk-or]).*$").matcher(part);
            if (match.find()) {
                this.lastColor = ChatColor.getByChar(match.group(1).charAt(0));
                this.filterColors(workingText);
                if (part.length() == 2) continue;
            }
            if (ChatColor.stripColor(part).isEmpty()) continue;
            workingText.put("text", ChatColor.stripColor(part));
            this.filterColors(workingText);
            if (!workingText.containsKey("color")) {
                workingText.put("color", "white");
            }
            this.workingGroup.add(workingText);
        }
        return this;
    }

    private JSONObject filterColors(JSONObject obj) {
        for (Map.Entry<String, Boolean> format : this.lastformats.entrySet()) {
            obj.put(format.getKey(), format.getValue());
        }
        if (this.lastColor.isFormat()) {
            String formatStr = this.lastColor.name().toLowerCase();
            if (this.lastColor.equals(ChatColor.MAGIC)) {
                formatStr = "obfuscated";
            }
            if (this.lastColor.equals(ChatColor.UNDERLINE)) {
                formatStr = "underlined";
            }
            this.lastformats.put(formatStr, true);
            obj.put(formatStr, true);
        }
        if (this.lastColor.isColor()) {
            obj.put("color", this.lastColor.name().toLowerCase());
        }
        if (this.lastColor.equals(ChatColor.RESET)) {
            obj.put("color", "white");
            for (String format2 : this.lastformats.keySet()) {
                this.lastformats.put(format2, false);
                obj.put(format2, false);
            }
        }
        return obj;
    }

    public UltimateFancy next() {
        if (this.workingGroup.size() > 0) {
            for (JSONObject obj : this.workingGroup) {
                if (!obj.containsKey("text") || obj.get("text").toString().length() <= 0) continue;
                for (ExtraElement element : this.pendentElements) {
                    obj.put(element.getAction(), element.getJson());
                }
                this.constructor.add(obj);
            }
        }
        this.workingGroup = new ArrayList<JSONObject>();
        this.pendentElements = new ArrayList<ExtraElement>();
        return this;
    }

    public UltimateFancy clickRunCmd(String cmd) {
        this.pendentElements.add(new ExtraElement("clickEvent", this.parseJson("run_command", cmd)));
        return this;
    }

    public UltimateFancy clickSuggestCmd(String cmd) {
        this.pendentElements.add(new ExtraElement("clickEvent", this.parseJson("suggest_command", cmd)));
        return this;
    }

    public UltimateFancy clickOpenURL(String url) {
        this.pendentElements.add(new ExtraElement("clickEvent", this.parseJson("open_url", url)));
        return this;
    }

    public UltimateFancy hoverShowText(String text) {
        this.pendentElements.add(new ExtraElement("hoverEvent", this.parseHoverText(text)));
        return this;
    }

    public UltimateFancy hoverShowItem(ItemStack item) {
        this.pendentElements.add(new ExtraElement("hoverEvent", this.parseHoverItem(item)));
        return this;
    }

    public String toOldFormat() {
        StringBuilder result = new StringBuilder();
        Iterator iterator = this.constructor.iterator();
        while (iterator.hasNext()) {
            Object mjson = iterator.next();
            JSONObject json = (JSONObject)mjson;
            if (!json.containsKey("text")) continue;
            String colorStr = json.get("color").toString();
            if (ChatColor.valueOf(colorStr.toUpperCase()) != null) {
                ChatColor color = ChatColor.valueOf(colorStr.toUpperCase());
                if (color.equals(ChatColor.WHITE)) {
                    result.append(String.valueOf(ChatColor.RESET));
                } else {
                    result.append(String.valueOf(color));
                }
            }
            for (ChatColor frmt : ChatColor.values()) {
                if (frmt.isColor()) continue;
                String frmtStr = frmt.name().toLowerCase();
                if (frmt.equals(ChatColor.MAGIC)) {
                    frmtStr = "obfuscated";
                }
                if (frmt.equals(ChatColor.UNDERLINE)) {
                    frmtStr = "underlined";
                }
                if (!json.containsKey(frmtStr)) continue;
                result.append(String.valueOf(frmt));
            }
            result.append(json.get("text").toString());
        }
        return result.toString();
    }

    private JSONObject parseHoverText(String text) {
        text = ChatColor.translateAlternateColorCodes('&', text);
        JSONArray extraArr = this.addColorToArray(text);
        JSONObject objExtra = new JSONObject();
        objExtra.put("text", "");
        objExtra.put("extra", extraArr);
        JSONObject obj = new JSONObject();
        obj.put("action", "show_text");
        obj.put("value", objExtra);
        return obj;
    }

    private JSONObject parseJson(String action, String value) {
        JSONObject obj = new JSONObject();
        obj.put("action", action);
        obj.put("value", value);
        return obj;
    }

    private JSONObject parseHoverItem(ItemStack item) {
        StringBuilder itemBuild = new StringBuilder();
        StringBuilder itemTag = new StringBuilder();
        String itemType = item.getType().toString().replace("_ITEM", "").replace("_SPADE", "_SHOVEL").replace("GOLD_", "GOLDEN_");
        itemBuild.append("id:" + itemType + ",Count:" + 1 + ",Damage:" + item.getDurability() + ",");
        if (item.hasItemMeta()) {
            StringBuilder itemEnch;
            StringBuilder lore;
            ItemMeta meta = item.getItemMeta();
            if (meta.hasLore()) {
                lore = new StringBuilder();
                for (String string : meta.getLore()) {
                    lore.append(String.valueOf(String.valueOf(string)) + ",");
                }
                itemTag.append("display:{Lore:[" + lore.toString().substring(0, lore.length() - 1) + "]},");
            } else if (meta.hasDisplayName()) {
                itemTag.append("display:{Name:" + meta.getDisplayName() + "},");
            } else if (meta.hasLore() && meta.hasDisplayName()) {
                lore = new StringBuilder();
                for (String string : meta.getLore()) {
                    lore.append(String.valueOf(String.valueOf(string)) + ",");
                }
                itemTag.append("display:{Name:" + meta.getDisplayName() + ",Lore:[" + lore.toString().substring(0, lore.length() - 1) + "]},");
            }
            if (meta instanceof PotionMeta) {
                itemEnch = new StringBuilder();
                itemEnch.append("CustomPotionEffects:[");
                Potion pot = Potion.fromItemStack(item);
                itemEnch.append("{Id:" + pot.getType().getEffectType().getId() + ",Duration:" + pot.getType().getEffectType().getDurationModifier() + ",Ambient:true,},");
                itemTag.append(String.valueOf(String.valueOf(itemEnch.toString().substring(0, itemEnch.length() - 1))) + "],");
            } else if (meta instanceof EnchantmentStorageMeta) {
                itemEnch = new StringBuilder();
                itemEnch.append("ench:[");
                for (Map.Entry entry : ((EnchantmentStorageMeta)((Object)meta)).getStoredEnchants().entrySet()) {
                    itemEnch.append("{id:" + ((Enchantment)entry.getKey()).getId() + ",lvl:" + entry.getValue() + "},");
                }
                itemTag.append(String.valueOf(String.valueOf(itemEnch.toString().substring(0, itemEnch.length() - 1))) + "],");
            } else if (meta.hasEnchants()) {
                itemEnch = new StringBuilder();
                itemEnch.append("ench:[");
                for (Map.Entry entry : meta.getEnchants().entrySet()) {
                    itemEnch.append("{id:" + ((Enchantment)entry.getKey()).getId() + ",lvl:" + entry.getValue() + "},");
                }
                itemTag.append(String.valueOf(String.valueOf(itemEnch.toString().substring(0, itemEnch.length() - 1))) + "],");
            }
        }
        if (itemTag.length() > 0) {
            itemBuild.append("tag:{" + itemTag.toString().substring(0, itemTag.length() - 1) + "},");
        }
        JSONObject obj = new JSONObject();
        obj.put("action", "show_item");
        obj.put("value", ChatColor.stripColor("{" + itemBuild.toString().substring(0, itemBuild.length() - 1).replace(" ", "_") + "}"));
        return obj;
    }

    private JSONArray addColorToArray(String text) {
        JSONArray extraArr = new JSONArray();
        ChatColor color = ChatColor.WHITE;
        for (String part : text.split("(?=§[0-9a-fk-or])")) {
            JSONObject objExtraTxt = new JSONObject();
            Matcher match = Pattern.compile("^§([0-9a-fk-or]).*$").matcher(part);
            if (match.find()) {
                color = ChatColor.getByChar(match.group(1).charAt(0));
                if (part.length() == 2) continue;
            }
            objExtraTxt.put("text", ChatColor.stripColor(part));
            if (color.isColor()) {
                objExtraTxt.put("color", color.name().toLowerCase());
            }
            if (color.equals(ChatColor.RESET)) {
                objExtraTxt.put("color", "white");
            }
            if (color.isFormat()) {
                if (color.equals(ChatColor.MAGIC)) {
                    objExtraTxt.put("obfuscated", true);
                } else {
                    objExtraTxt.put(color.name().toLowerCase(), true);
                }
            }
            extraArr.add(objExtraTxt);
        }
        return extraArr;
    }

    private String toJson() {
        return "[\"\"," + this.constructor.toJSONString().substring(1);
    }

    public void send(CommandSender to) {
        this.next();
        if (to instanceof Player) {
            this.performCommand(Bukkit.getConsoleSender(), "tellraw " + to.getName() + " " + this.toJson());
        } else {
            to.sendMessage(this.toOldFormat());
        }
    }

    private void performCommand(CommandSender sender, String command) {
        Bukkit.getScheduler().runTask(Core.getInstance(), () -> Bukkit.getServer().dispatchCommand(sender, command));
    }

    public class ExtraElement {
        private String action;
        private JSONObject json;

        public ExtraElement(String action, JSONObject json) {
            this.action = action;
            this.json = json;
        }

        public String getAction() {
            return this.action;
        }

        public JSONObject getJson() {
            return this.json;
        }
    }
}
