package accountCreator;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.didisoft.pgp.PGPException;
import com.didisoft.pgp.PGPLib;

public class PgbDescrypt {

	public static void main(String[] args) throws Exception {
		// create an instance of the library
		PGPLib pgp = new PGPLib();

		String openpgpMessage = "-----BEGIN PGP MESSAGE-----\nVersion: ProtonMail\n\n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\nulXnYlOgPI/sxwIXs66H3PEcIVbQJgLrekfqe/g/SLhmTNI/HD1EzZ1qK8VJ\noiYnVThUJsS7OscuDiTFRfVS4RWQDBVrYGiKnU44msxAfFaiN1rBt47DbfGn\naCChYC5tvm82GUVVuh0uy+8HhcGTAX/godxFCQ2mJ0YJHJk1L8WsdYI1z3Ze\nV740Jrj+394h98F7dw5oFnHxXKXPIKlaaKMbZB+LpJPGoUPS/mAyzTa18yq2\nB+cQutKc2bRtDoCnVKpLn6ZCJKSKM0kpnW3KTsS98rQujHqAAwlw/Imdjxv5\nOab2JaVcQ/Ot0T5dD3Pb4U03kxZi/rv68EF1cp9f+lOdBUI/wurvgpcAO4Hm\nInWZ6lD6eeduu3ti240x7ZREvzZCHfGrUcpz4kH62r7zodYSbdrag0/USZcS\nqigORYlgk8UNlKTrCUZzA7aGzgb+E+71Kq2lB8cLzzrZrbQ9nRvPeeZszgV8\njjdtPym13qFa+L60nOSTZwhSUqiePvRzOIqms7v3rGbsJx4q8IqcaUnvY/pF\nW/KaraofYxKoW6JU+Qc5ZzhrHFythOR43196Du+yyTpu63j+Sasp97jqqXN6\nr0DpnZaRIqJkfkmumtgWaoJs1R9NHZnQVpkcnagjpro1qJygzD8mqQvgEOOc\nm+R9TkBl2JfwWKwhKaI9XpQ66xa+t1GEtclTZV8wftO8R0fM9Nt42AnduoqW\nhIVSRq7vhGOF1lj0NGSvh9dFIYJqkNum5zrpKkyoRtVW1XE9SZzu30JVoTlf\nv0Td+HMC0yxVbqj7D4C9Ot8/RfFTnM5+ViEaQ55xIbTEcEgTZev2/Xw8sjHS\nElna/tEvlM0hLt6FUAnnJR/gZifjEDUQbmL09uoR71eyIHUy61yoTPIP3Xgl\nSFEPrBDx5cXB2DpxhI9UzgyW7bqlAjP+S9+W6lxU18TjUYdLFmesiv0AlcBW\nhY67/ad5DE/qeTY/XohtotATQR5MAozO7otoYSVSn2WW4K1S57f9pIB9Lux2\nIkU2Vd5t76Cgd98KTdMEOZxNHcD+dw2EPh4N6cpnY9XoNTH+3FFPclaap0BP\nxYkBO+SxygHT+Vjuu9Mdv86zdJemogmfOVU75jwA2xK2WG/YiQQKUmy3/u6W\niGJTyZO8Sq6UW4FCCx3lIhoIJfbnl01XAKs72ViGD2Cn2zkcALyuPt1WyAoI\n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\nmjAPuwQ3VWU5X4Qfe5qpeA==\n=Nzaw\n-----END PGP MESSAGE-----\n";
		openpgpMessage = openpgpMessage.replaceAll("\\n", "\n");

		String privateKeyFile = Config.privateKeyFileFromProtonmailPgpLocation;
		String privateKeyPassword = Config.privateKeyPassword;

		String decryptedMessage = pgp.decryptString(openpgpMessage, privateKeyFile, privateKeyPassword);

		Document document = Jsoup.parse(decryptedMessage);
		Elements elements = document.getElementsContainingText("https://secure.runescape.com");

		for (Element element : elements) {
			if (element.hasAttr("href")) {
				System.out.println("found el: " + element.text());
			}
		}

	}

	public String decryptPgpMessage(String body) throws PGPException, IOException {
		PGPLib pgp = new PGPLib();

		body = body.replaceAll("\\n", "\n");

		String privateKeyFile = Config.privateKeyFileFromProtonmailPgpLocation;
		String privateKeyPassword = Config.privateKeyPassword;

		String decryptedMessage = pgp.decryptString(body, privateKeyFile, privateKeyPassword);

		Document document = Jsoup.parse(decryptedMessage);
		Elements elements = document.getElementsContainingText("https://secure.runescape.com");

		for (Element element : elements) {
			if (element.hasAttr("href")) {
				System.out.println("found el: " + element.text());
				return element.text();
			}
		}
		return null;
	}
}