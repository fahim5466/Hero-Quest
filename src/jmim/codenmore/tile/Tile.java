package jmim.codenmore.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	public static final int TILEWIDTH = 50;
	public static final int TILEHEIGHT = 50;
	protected final int id;
	private BufferedImage texture;
	public static Tile[] tiles=new Tile[700];
	public static Tile grassTile;
	
	public static void init()
	{
		
	 new Night1(200);
		
	 new Unseen(250);
	 new Hive(251);
	 new Lava(252);
	
	 grassTile = new GrassTile(0);
	 new GrassTile1(1);
	 new GrassTile2(2);
	 new GrassTile3(3);
	 new GrassTile4(4);
	 new GrassTile5(5);
	 new GrassTile6(6);
	 new GrassTile7(7);
	 new GrassTile8(8);
	 new GrassTile9(9);
	 new GrassTile10(10);
	 new GrassTile11(11);
	 new FallTile1(301);
	 new FallTile2(302);
	 new FallTile3(303);
	 new FallTile4(304);
	 new FallTile5(305);
	 new FallTile6(306);
	 new FallTile7(307);
	 new FallTile8(308);
	 new FallTile9(309);
	 new FallTile10(310);
	 new FallTile11(311);
	

	 new GrassTile11(12);
	 new GrassTile12(13);
	 new GrassTile13(14);
	 new GrassTile14(15);
	 new GrassTile15(16);
	 new GrassTile16(17);
	 new GrassTile17(18);
	 new GrassTile18(19);
	 new GrassTile19(20);
	 new GrassTile20(21);
	 new GrassTile21(22);
	
	 new FallTile11(312);
	 new FallTile12(313);
	 new FallTile13(314);
	 new FallTile14(315);
	 new FallTile15(316);
	 new FallTile16(317);
	 new FallTile17(318);
	 new FallTile18(319);
	 new FallTile19(320);
	 new FallTile20(321);
	 new FallTile21(322);
	
	 new GrassTile22(23);
	 new GrassTile23(24);
	 new GrassTile24(25);
	 new GrassTile25(26);
	 new GrassTile26(27);
	 new GrassTile27(28);
	 new GrassTile29(29);
	 new GrassTile30(30);
	 new GrassTile31(31);
	 new GrassTile32(32);
	 new GrassTile33(33);
	
	 new FallTile22(323);
	 new FallTile23(324);
	 new FallTile24(325);
	 new FallTile25(326);
	 new FallTile26(327);
	 new FallTile27(328);
	 new FallTile29(329);
	 new FallTile30(330);
	 new FallTile31(331);
	 new FallTile32(332);
	 new FallTile33(333);
	
	 new GrassTile34(34);
	 new GrassTile35(35);
	 new GrassTile36(36);
	 new GrassTile37(37);
	 new GrassTile38(38);
	 new GrassTile39(39);
	 new GrassTile40(40);
	 new GrassTile41(41);
	 new GrassTile42(42);
	 new GrassTile43(43);
	 new GrassTile44(44);
	
	 new FallTile34(334);
	 new FallTile35(335);
	 new FallTile36(336);
	 new FallTile37(337);
	 new FallTile38(338);
	 new FallTile39(339);
	 new FallTile40(340);
	 new FallTile41(341);
	 new FallTile42(342);
	 new FallTile43(343);
	 new FallTile44(344);
	
	 new GrassTile45(45);
	 new GrassTile46(46);
	 new GrassTile47(47);
	 new GrassTile48(48);
	 new GrassTile49(49);
	 new GrassTile50(50);
	 new GrassTile51(51);
	 new GrassTile52(52);
	 new GrassTile53(53);
	 new GrassTile54(54);
	 new GrassTile55(55);
	
	 new FallTile45(345);
	 new FallTile46(346);
	 new FallTile47(347);
	 new FallTile48(348);
	 new FallTile49(349);
	 new FallTile50(350);
	 new FallTile51(351);
	 new FallTile52(352);
	 new FallTile53(353);
	 new FallTile54(354);
	 new FallTile55(355);
	
	 new GrassTile56(56);
	 new GrassTile57(57);
	 new GrassTile58(58);
	 new GrassTile59(59);
	 new GrassTile60(60);
	 new GrassTile61(61);
	 new GrassTile62(62);
	 new GrassTile63(63);
	 new GrassTile63(64);
	 new GrassTile64(65);
	 new GrassTile65(66);
	
	 new FallTile56(356);
	 new FallTile57(357);
	 new FallTile58(358);
	 new FallTile59(359);
	 new FallTile60(360);
	 new FallTile61(361);
	 new FallTile62(362);
	 new FallTile63(363);
	 new FallTile63(364);
	 new FallTile64(365);
	 new FallTile65(366);
	
	 new GrassTile67(67);
	 new GrassTile68(68);
	 new GrassTile69(69);
	 new GrassTile70(70);
	 new GrassTile71(71);
	 new GrassTile72(72);
	 new GrassTile73(73);
	 new GrassTile74(74);
	 new GrassTile75(75);
	 new GrassTile76(76);
	 new GrassTile77(77);
	
	 new FallTile67(367);
	 new FallTile68(368);
	 new FallTile69(369);
	 new FallTile70(370);
	 new FallTile71(371);
	 new FallTile72(372);
	 new FallTile73(373);
	 new FallTile74(374);
	 new FallTile75(375);
	 new FallTile76(376);
	 new FallTile77(377);
	
	
	 new PondDirtTile1(81);
	 new PondDirtTile2(82);
	 new PondDirtTile3(83);
	 new PondDirtTile4(84);
	 new PondDirtTile5(85);
	 new PondDirtTile6(86);
	 new PondDirtTile7(87);
	 new PondDirtTile8(88);
	 new PondDirtTile9(89);
	 new PondDirtTile10(90);
	 new PondDirtTile11(91);
	 new PondDirtTile11(92);
	
	 new ExitTile1(101);
	 new ExitTile2(102);
	 new ExitTile3(103);
	 new ExitTile4(104);
	 new ExitTile5(105);
	 new ExitTile6(106);
	 new ExitTile7(107);
	 new ExitTile8(108);
	
	 new ExitTile9(109);
	 new ExitTile10(110);
	 new ExitTile11(111);
	 new ExitTile12(112);
	 new ExitTile13(113);
	 new ExitTile14(114);
	 new ExitTile15(115);
	 new ExitTile16(116);
	
	 new ExitTile17(117);
	 new ExitTile18(118);
	 new ExitTile19(119);
	 new ExitTile20(120);
	 new ExitTile21(121);
	 new ExitTile22(122);
	 new ExitTile23(123);
	 new ExitTile24(124);
	
	 new ExitTile25(125);
	 new ExitTile26(126);
	 new ExitTile27(127);
	 new ExitTile28(128);
	 new ExitTile29(129);
	 new ExitTile30(130);
	 new ExitTile31(131);
	 new ExitTile32(132);
	
	
	 new GrassRockTile(135);
	
	 new WallTile(201);
	 new Night2(202);
	
	 new Floor1(203);
	 new Floor2(204);
	 new Floor3(205);
	 new Floor4(206);
	 new Dirt1(207);
	 new Dirt2(208);
	 new Dirt3(209);
	 new Dirt4(210);
	
	
	 new TreeDown1(390);
	 new TreeDown2(391);
	 new TreeDown3(392);
	 new TreeDown4(393);
	 new TreeDown5(394);
	 new TreeDown6(395);
	 new TreeDown7(396);
	
	
	 new CityFloorTile(450);
	
	 new RockTile(151);
	 new TreeTile(152);
	 
	}
	
	public Tile(BufferedImage texture,int id)
	{
		this.texture=texture;
		this.id=id;
		new dev.fahim.tileGame.tile.Tile(texture, id);
	}

	public int getId() {
		return id;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g,int x,int y)
	{
		g.drawImage(texture,x,y,TILEWIDTH,TILEHEIGHT,null);

	}
	
	public boolean isSolid()
	{
		return false;
	}

}
