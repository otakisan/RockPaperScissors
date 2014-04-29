package jp.itscore.games.rps;

import java.io.IOException;

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

		// Player1入力受付
		System.out.println("プレイヤー１ 入力してください");
		System.out.println(String.format(
				FORMAT_RPS_HAND_SIGNS,
				HAND_SIGN_CODE_ROCK, HAND_SIGN_CODE_SCISSORS, HAND_SIGN_CODE_PAPER
				));

		// Player2入力受付

		// 勝ち負け判定

		// 結果表示

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
}
