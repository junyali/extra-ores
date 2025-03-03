package io.github.junyali.extra_ores.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

import static io.github.junyali.extra_ores.EXtraOres.MOD_ID;

public class EXtraOresDataGenerator implements DataGeneratorEntrypoint {

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        LOGGER.info("Running DataGenerator...");

        pack.addProvider(OreTagGenerator::new);
        pack.addProvider(EnglishLangProvider::new);
    }

    private static class OreTagGenerator extends FabricTagProvider.ItemTagProvider {
        public OreTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        private static final TagKey<Item> SPECIAL_ORE_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, "special_ore_items"));

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            getOrCreateTagBuilder(SPECIAL_ORE_ITEMS)
                    .add(Identifier.of(MOD_ID, "luminitite"))
                    .add(Identifier.of(MOD_ID, "raw_luminitite"))
                    .add(Identifier.of(MOD_ID, "infernium_clump"))
                    .add(Identifier.of(MOD_ID, "voidium_dust"))
                    .add(Identifier.of(MOD_ID, "cryo_shard"));
        }
    }

    public static class EnglishLangProvider extends FabricLanguageProvider {
        protected EnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, "en_gb", registryLookup);
        }

        @Override
        public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
            addItemTranslations(translationBuilder);
            addBlockTranslations(translationBuilder);
            addToolTranslations(translationBuilder);
            addEquipmentTranslations(translationBuilder);
            addConsumableTranslations(translationBuilder);
        }

        private void addItemTranslations(TranslationBuilder translationBuilder) {
            // Ores
            translationBuilder.add("item.extra-ores.luminitite", "Luminitite");
            translationBuilder.add("item.extra-ores.raw_luminitite", "Raw Luminitite");
            translationBuilder.add("item.extra-ores.infernium_clump", "Infernium Clump");
            translationBuilder.add("item.extra-ores.voidium_dust", "Voidium Dust");
            translationBuilder.add("item.extra-ores.cryo_shard", "Cryo Shard");
            translationBuilder.add("tag.extra-ores.special_ore_items", "Special Ore Items");

            // Ores / Item variants of blocks
            translationBuilder.add("item.extra-ores.luminitite_ore", "Luminitite Ore");
            translationBuilder.add("item.extra-ores.deepslate_luminitite_ore", "Deepslate Luminitite Ore");
            translationBuilder.add("item.extra-ores.luminitite_block", "Block of Luminitite");
            translationBuilder.add("item.extra-ores.nether_infernium_ore", "Infernium Ore");
            translationBuilder.add("item.extra-ores.infernium_block", "Block of Infernium");
            translationBuilder.add("item.extra-ores.ignis_block", "Ignis");
            translationBuilder.add("item.extra-ores.scorched_ignis_block", "Scorched Ignis");
            translationBuilder.add("item.extra-ores.end_voidium_ore", "Voidium Ore");
            translationBuilder.add("item.extra-ores.voidium_block", "Block of Voidium");
            translationBuilder.add("item.extra-ores.ice_cryocite_ore", "Cryoice Ore");
            translationBuilder.add("item.extra-ores.cryocite_ore", "Cryocite Ore");
            translationBuilder.add("item.extra-ores.deepslate_cryocite_ore", "Deepslate Cryocite Ore");
            translationBuilder.add("item.extra-ores.cryocite_block", "Block of Cryocite");
            translationBuilder.add("item.extra-ores.freezing_cryocite_block", "Block of Freezing Cryocite");

            // Smithing Transformation Templates
            translationBuilder.add("item.extra-ores.infernium_upgrade_smithing_template", "Infernium Upgrade Smithing Template");
            translationBuilder.add("item.extra-ores.voidium_upgrade_smithing_template", "Voidium Upgrade Smithing Template");
            translationBuilder.add("item.extra-ores.cryocite_upgrade_smithing_template", "Cryocite Upgrade Smithing Template");

            // Miscellaneous
            translationBuilder.add("item.extra-ores.scorched_coal", "Scorched Coal");
        }

        private void addBlockTranslations(TranslationBuilder translationBuilder) {
            // Ores
            translationBuilder.add("block.extra-ores.luminitite_ore", "Luminitite Ore");
            translationBuilder.add("block.extra-ores.deepslate_luminitite_ore", "Deepslate Luminitite Ore");
            translationBuilder.add("block.extra-ores.luminitite_block", "Block of Luminitite");
            translationBuilder.add("block.extra-ores.nether_infernium_ore", "Infernium Ore");
            translationBuilder.add("block.extra-ores.infernium_block", "Block of Infernium");
            translationBuilder.add("block.extra-ores.ignis_block", "Ignis");
            translationBuilder.add("block.extra-ores.scorched_ignis_block", "Scorched Ignis");
            translationBuilder.add("block.extra-ores.end_voidium_ore", "Voidium Ore");
            translationBuilder.add("block.extra-ores.voidium_block", "Block of Voidium");
            translationBuilder.add("block.extra-ores.ice_cryocite_ore", "Cryoice Ore");
            translationBuilder.add("block.extra-ores.cryocite_ore", "Cryocite Ore");
            translationBuilder.add("block.extra-ores.deepslate_cryocite_ore", "Deepslate Cryocite Ore");
            translationBuilder.add("block.extra-ores.cryocite_block", "Block of Cryocite");
            translationBuilder.add("block.extra-ores.freezing_cryocite_block", "Block of Freezing Cryocite");
        }

        private void addToolTranslations(TranslationBuilder translationBuilder) {
            // Infernium
            translationBuilder.add("item.extra-ores.infernium_sword", "Infernium Sword");
            translationBuilder.add("item.extra-ores.infernium_pickaxe", "Infernium Pickaxe");
            translationBuilder.add("item.extra-ores.infernium_axe", "Infernium Axe");
            translationBuilder.add("item.extra-ores.infernium_shovel", "Infernium Shovel");
            translationBuilder.add("item.extra-ores.infernium_hoe", "Infernium Hoe");

            // Cryocite
            translationBuilder.add("item.extra-ores.cryocite_sword", "Cryocite Sword");
            translationBuilder.add("item.extra-ores.cryocite_pickaxe", "Cryocite Pickaxe");
            translationBuilder.add("item.extra-ores.cryocite_axe", "Cryocite Axe");
            translationBuilder.add("item.extra-ores.cryocite_shovel", "Cryocite Shovel");
            translationBuilder.add("item.extra-ores.cryocite_hoe", "Cryocite Hoe");

            // Voidium
            translationBuilder.add("item.extra-ores.voidium_sword", "Voidium Sword");
            translationBuilder.add("item.extra-ores.voidium_pickaxe", "Voidium Pickaxe");
            translationBuilder.add("item.extra-ores.voidium_axe", "Voidium Axe");
            translationBuilder.add("item.extra-ores.voidium_shovel", "Voidium Shovel");
            translationBuilder.add("item.extra-ores.voidium_hoe", "Voidium Hoe");
        }

        private void addEquipmentTranslations(TranslationBuilder translationBuilder) {
            // Infernium
            translationBuilder.add("item.extra-ores.infernium_helmet", "Infernium Helmet");
            translationBuilder.add("item.extra-ores.infernium_chestplate", "Infernium Chestplate");
            translationBuilder.add("item.extra-ores.infernium_leggings", "Infernium Leggings");
            translationBuilder.add("item.extra-ores.infernium_boots", "Infernium Boots");

            // Cryocite
            translationBuilder.add("item.extra-ores.cryocite_helmet", "Cryocite Helmet");
            translationBuilder.add("item.extra-ores.cryocite_chestplate", "Cryocite Chestplate");
            translationBuilder.add("item.extra-ores.cryocite_leggings", "Cryocite Leggings");
            translationBuilder.add("item.extra-ores.cryocite_boots", "Cryocite Boots");

            // Voidium
            translationBuilder.add("item.extra-ores.voidium_helmet", "Voidium Helmet");
            translationBuilder.add("item.extra-ores.voidium_chestplate", "Voidium Chestplate");
            translationBuilder.add("item.extra-ores.voidium_leggings", "Voidium Leggings");
            translationBuilder.add("item.extra-ores.voidium_boots", "Voidium Boots");
        }

        private void addConsumableTranslations(TranslationBuilder translationBuilder) {
            translationBuilder.add("item.extra-ores.luminous_apple", "Luminous Apple");
            translationBuilder.add("item.extra-ores.fiery_apple", "Fiery Apple");
            translationBuilder.add("item.extra-ores.inferno_stew", "Inferno Stew");
            translationBuilder.add("item.extra-ores.fusion_carrot", "Fusion Carrot");
            translationBuilder.add("item.extra-ores.void_berries", "Void Berries");
        }
    }

}
