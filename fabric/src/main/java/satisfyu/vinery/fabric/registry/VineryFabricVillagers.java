package satisfyu.vinery.fabric.registry;

import de.cristelknight.doapi.common.util.VillagerUtil;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import satisfyu.vinery.registry.ObjectRegistry;
import satisfyu.vinery.util.VineryIdentifier;

@SuppressWarnings("unused, deprecation")
public class VineryFabricVillagers {

    private static final VineryIdentifier WINEMAKER_POI_IDENTIFIER = new VineryIdentifier("winemaker_poi");
    public static final PoiType WINEMAKER_POI = PointOfInterestHelper.register(WINEMAKER_POI_IDENTIFIER, 1, 12, ObjectRegistry.APPLE_PRESS.get());
    public static final VillagerProfession WINEMAKER = Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, new ResourceLocation("vinery", "winemaker"), VillagerProfessionBuilder.create().id(new ResourceLocation("vinery", "winemaker")).workstation(ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, WINEMAKER_POI_IDENTIFIER)).build());

    public static void init() {
        TradeOfferHelper.registerVillagerOffers(WINEMAKER, 1, factories -> {
            factories.add(new VillagerUtil.BuyForOneEmeraldFactory(ObjectRegistry.RED_GRAPE.get(), 15, 4, 5));
            factories.add(new VillagerUtil.BuyForOneEmeraldFactory(ObjectRegistry.WHITE_GRAPE.get(), 15, 4, 5));
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.RED_GRAPE_SEEDS.get(), 2, 1, 5));
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.WHITE_GRAPE_SEEDS.get(), 2, 1, 5));
        });
        TradeOfferHelper.registerVillagerOffers(WINEMAKER, 2, factories -> factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.WINE_BOTTLE.get(), 1, 2, 7)));
        TradeOfferHelper.registerVillagerOffers(WINEMAKER, 3, factories -> {
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.FLOWER_BOX.get(), 3, 1, 10));
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.WHITE_GRAPE_BAG.get(), 7, 1, 10));
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.RED_GRAPE_BAG.get(), 7, 1, 10));

        });
        TradeOfferHelper.registerVillagerOffers(WINEMAKER, 4, factories -> {
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.BASKET.get(), 4, 1, 10));
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.FLOWER_POT_BIG.get(), 5, 1, 10));
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.WINDOW.get(), 12, 1, 10));
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.DARK_CHERRY_BEAM.get(), 6, 1, 10));
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.TAIGA_RED_GRAPE_SEEDS.get(), 2, 1, 5));
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.TAIGA_WHITE_GRAPE_SEEDS.get(), 2, 1, 5));


        });
        TradeOfferHelper.registerVillagerOffers(WINEMAKER, 5, factories -> {
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.WINE_BOX.get(), 10, 1, 10));
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.LILITU_WINE.get(), 4, 1, 10));
            factories.add(new VillagerUtil.SellItemFactory(ObjectRegistry.CALENDAR.get(), 12, 1, 15));
        });
    }
}
