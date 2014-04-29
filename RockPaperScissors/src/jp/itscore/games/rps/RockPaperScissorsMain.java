package jp.itscore.games.rps;

public class RockPaperScissorsMain {

	// javaの定数はインスタンスごとに別の値を保持できる？staticつけないといけないみたい。
	static final char USER_INPUT_YES = 'Y';
	static final char USER_INPUT_NO = 'N';

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// VSみたいにTODO表記しただけでは、タスクリストにリストアップされない？

		try{

		// 開始確認表示＆入力受付
		// TODO 関数化、メッセージ定義

		char userInput;

		do{
			System.out.println("ゲームを開始しますか？");
			System.out.println("はい：Y いいえ：N");

			userInput = (char)System.in.read();

			if(userInput == USER_INPUT_NO){
				return;
			}

		}while(userInput != USER_INPUT_NO && userInput != USER_INPUT_YES);

		// 入力判定 sabun

		// Player1入力受付

		// Player2入力受付

		// 勝ち負け判定

		// 結果表示

		// 再戦受付

		// 最終結果表示

		// 終了確認
		}
		catch(Exception e){

		}

	}

}
