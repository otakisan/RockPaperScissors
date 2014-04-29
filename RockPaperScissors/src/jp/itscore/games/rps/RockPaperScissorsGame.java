package jp.itscore.games.rps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RockPaperScissorsGame {

	// javaの定数はインスタンスごとに別の値を保持できる？staticつけないといけないみたい。
	static final char USER_INPUT_YES = 'Y';
	static final char USER_INPUT_NO = 'N';

	static final char HAND_SIGN_CODE_ROCK = 'a';
	static final char HAND_SIGN_CODE_PAPER = 'd';
	static final char HAND_SIGN_CODE_SCISSORS = 's';
	static final String FORMAT_RPS_HAND_SIGNS = "グー：%c チョキ：%c パー：%c";

	public void Run(){
		try{

		// 開始確認表示＆入力受付
		// TODO 関数化、メッセージ定義

		char userInput;

		do{
			System.out.println("ゲームを開始しますか？");
			System.out.println("はい：Y いいえ：N");

			// TODO readだと改行コードを含め、2回ループしてしまう。
			userInput = readFrontAndSkipAllLeftBytes();
			if(userInput == USER_INPUT_NO){
				System.out.println("ゲームを終了します。");
				return;
			}

		}while(userInput != USER_INPUT_NO && userInput != USER_INPUT_YES);

		// 入力判定
		System.out.println("入力判定を行います");

		final int playerCount = 2;
		int playerNo = 1;
		List<Character> validCodes = new ArrayList<Character>();
		validCodes.add(HAND_SIGN_CODE_ROCK);
		validCodes.add(HAND_SIGN_CODE_SCISSORS);
		validCodes.add(HAND_SIGN_CODE_PAPER);

		char[] handSigns = new char[playerCount];

		do{
			// Player1 & 2入力受付
			System.out.println(String.format("プレイヤー%d 入力してください", playerNo));
			System.out.println(String.format(
					FORMAT_RPS_HAND_SIGNS,
					HAND_SIGN_CODE_ROCK, HAND_SIGN_CODE_SCISSORS, HAND_SIGN_CODE_PAPER
					));

			userInput = readFrontAndSkipAllLeftBytes();
			int handSignIndex = validCodes.indexOf(userInput);

			if(handSignIndex != -1){

				handSigns[playerNo-1] = validCodes.get(handSignIndex);
				playerNo++;
			}

		}while(playerNo <= playerCount);

		// 勝ち負け判定
		int battleResult = battle(handSigns[0], handSigns[1]);

		// 結果表示
		switch(battleResult){
			case -1:
				System.out.println(String.format("プレイヤー１の勝利"));
				break;
			case 0:
				System.out.println(String.format("引き分け"));
				break;
			case 1:
				System.out.println(String.format("プレイヤー２の勝利"));
				break;
			default:
				System.out.println(String.format("想定外の結果です"));
				break;
		}

		// 再戦受付

		// 最終結果表示

		// 終了確認
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		System.out.println("プログラムを終了します。");

	}

	/**
	 * 標準入力より先頭の1文字を読み取り、残りの入力を破棄します
	 * @return 標準入力より読み取った先頭の1文字
	 * @throws IOException InputStreamがスローする例外をそのままスローします
	 */
	private char readFrontAndSkipAllLeftBytes() throws IOException{

		char userInput = (char)System.in.read();
		int leftBytes = System.in.available();
		long actualSkippedBytes = System.in.skip(leftBytes);

		System.out.println(String.format("入力処理残[%d] スキップ[%d]", leftBytes, actualSkippedBytes));

		return userInput;
	}

	/**
	 * ジャンケンを行い、結果を返却します
	 * @param lhs プレイヤー１の手
	 * @param rhs プレイヤー２の手
	 * @return ジャンケンの結果(-1：プレイヤー１の勝ち 0：あいこ 1：プレイヤー２の勝ち)
	 */
	private int battle(char lhs, char rhs){
		if(lhs == rhs){
			return 0;
		}
		else if(lhs == HAND_SIGN_CODE_ROCK && rhs == HAND_SIGN_CODE_SCISSORS ||
				lhs == HAND_SIGN_CODE_SCISSORS && rhs == HAND_SIGN_CODE_PAPER ||
				lhs == HAND_SIGN_CODE_PAPER && rhs == HAND_SIGN_CODE_ROCK){
			return -1;
		}
		else{
			return 1;
		}
	}
}
