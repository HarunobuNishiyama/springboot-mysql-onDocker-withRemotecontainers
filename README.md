# このプロジェクトについて

## 概要

環境構築の記録・参考のために作ったものです。
以下のような構成になっています。

- `環境`: Docker
- `サーバー`: Spring Boot
- `DB`: MySQL
- `DBクライアント`: phpMyAdmin
- `エディタ`: VSCode(Remote - Containers を使用)

すぐに開発に取り掛かれるようなものにするために、サーバーと DB を用意し、簡素なテーブル検索機能まで実装されています。

## アプリケーションの起動に必要なもの

- Docker Desktop
- VSCode

## 起動手順

`./vscode/setting.json`に記載のある拡張機能を入れておいてください。

### 1.コンテナ起動

docker-compose.yml は`./docker`にあります。docker 関連のコマンドはここで実行してください。
まずは docker でコンテナを起動します。

```bash:
$ cd docker
$ docker-compose up -d
# 以下の表示でコンテナ起動完了
Creating mysql     ... done
Creating dbclient  ... done
Creating java  ... done
```

### 2.phpMyAdmin の起動確認

phpMyAdmin は 4200 番ポートで起動しています。
`http://localhost:4200/`に接続してデータを確認しておいてください。
`sample_schema`という DB に`account`テーブルがあります。初期データの内容は`./docker/mysql/sql_init` 以下にあるファイル内のクエリに基づきます。

### 3.Remote - Containers でコンテナ内の環境を開く

[Remote - Containers]()をインストールしていることを確認してください。

VSCode の画面左下に、`><`← のように括弧が合わさった緑色のボタンがあるのでそれを押してください。
選択肢が出るので、`Attach to Running Container`を選択します。

選択肢が続くので`/java`を選択してください。これで java コンテナの環境が展開されます。

### 4.ビルドと起動

上記手順の続きで、現在 java コンテナの`/app`ディレクトリにいる状態です。
まずはビルドします。

```
$ sh gradlew build
```

通常実行する場合は、`./build/libs/sample-0.0.1-SNAPSHOT.jar`を実行してください。

```
$ java -jar build/libs/sample-0.0.1-SNAPSHOT.jar
```

デバッグの際は、gradle を使って起動します。

```
$ sh gradlew bootRun
```

デバッガがアタッチされるまで起動を待機する設定になっているので、デバッガを起動します。

デバッグビューを開いて、`java(Attach)`をスタートさせます。これでアプリケーションがデバッグモードで
立ち上がります。

## 記事

環境構築の過程を記事にしています。
[Spring Boot プロジェクトを Docker 上で動かす](https://zenn.dev/nishiharu/articles/7f27b8c580f896)
