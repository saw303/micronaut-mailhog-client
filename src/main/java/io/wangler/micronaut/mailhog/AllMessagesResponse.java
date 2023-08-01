/*
 * Copyright 2022 Silvio Wangler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.wangler.micronaut.mailhog;

import io.micronaut.serde.annotation.Serdeable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Serdeable
public class AllMessagesResponse {

  private int total;
  private int count;
  private int start;
  private List<MailHogItem> items = new ArrayList<>();

  /*
      {
    "total": 1,
    "count": 1,
    "start": 0,
    "items": [
      {
        "ID": "G68wwdxYuftMFqqCrLdx02XRqmi0AJuRp1bcQci5QeU=@mailhog.example",
        "From": {
          "Relays": null,
          "Mailbox": "donotreply",
          "Domain": "zsc-supporter.ch",
          "Params": ""
        },
        "To": [
          {
            "Relays": null,
            "Mailbox": "kasse",
            "Domain": "zsc-supporter.ch",
            "Params": ""
          },
          {
            "Relays": null,
            "Mailbox": "tickets",
            "Domain": "zsc-supporter.ch",
            "Params": ""
          },
          {
            "Relays": null,
            "Mailbox": "homepage",
            "Domain": "zsc-supporter.ch",
            "Params": ""
          }
        ],
        "Content": {
          "Headers": {
            "Content-Type": [
              "multipart/mixed; \tboundary=\"----=_Part_0_229907978.1645458236232\""
            ],
            "Date": [
              "Mon, 21 Feb 2022 16:43:56 +0100 (CET)"
            ],
            "From": [
              "donotreply@zsc-supporter.ch"
            ],
            "MIME-Version": [
              "1.0"
            ],
            "Message-ID": [
              "\u003c1699206600.1.1645458236263@silicon.home\u003e"
            ],
            "Received": [
              "from silicon.home by mailhog.example (MailHog)\r\n          id G68wwdxYuftMFqqCrLdx02XRqmi0AJuRp1bcQci5QeU=@mailhog.example; Mon, 21 Feb 2022 15:44:02 +0000"
            ],
            "Return-Path": [
              "\u003cdonotreply@zsc-supporter.ch\u003e"
            ],
            "Subject": [
              "=?UTF-8?Q?ZSC_Supporter_Ticketing:_1_Tickets_f=C3=BCr_d?= =?UTF-8?Q?as_Spiel_vom_10.09.2021_wurden_reserviert?="
            ],
            "To": [
              "kasse@zsc-supporter.ch, tickets@zsc-supporter.ch,\thomepage@zsc-supporter.ch"
            ]
          },
          "Body": "------=_Part_0_229907978.1645458236232\r\nContent-Type: text/plain; charset=UTF-8\r\nContent-Transfer-Encoding: quoted-printable\r\n\r\nNeue Ticketbestellung\r\n\r\nSpiel vom: 22.02.2022, ZSC Lions - EV Zug\r\nF=C3=BCr Mitglied: Ren=C3=A9 Sterchi\r\nAnzahl Tickets Total: 1\r\nAnzahl Tickets Gratis: 1\r\nRechnungsbetrag: 0.00\r\nZustellung: Post\r\n\r\nDie Rechnung findest Du als PDF im Anhang.\r\n\r\n------=_Part_0_229907978.1645458236232--",
          "Size": 860,
          "MIME": null
        },
        "Created": "2022-02-21T15:44:02.833629Z",
        "MIME": {
          "Parts": [
            {
              "Headers": {
                "Content-Transfer-Encoding": [
                  "quoted-printable"
                ],
                "Content-Type": [
                  "text/plain; charset=UTF-8"
                ]
              },
              "Body": "Neue Ticketbestellung\r\n\r\nSpiel vom: 22.02.2022, ZSC Lions - EV Zug\r\nF=C3=BCr Mitglied: Ren=C3=A9 Sterchi\r\nAnzahl Tickets Total: 1\r\nAnzahl Tickets Gratis: 1\r\nRechnungsbetrag: 0.00\r\nZustellung: Post\r\n\r\nDie Rechnung findest Du als PDF im Anhang.",
              "Size": 330,
              "MIME": null
            },
            {
              "Headers": {},
              "Body": "--",
              "Size": 2,
              "MIME": null
            }
          ]
        },
        "Raw": {
          "From": "donotreply@zsc-supporter.ch",
          "To": [
            "kasse@zsc-supporter.ch",
            "tickets@zsc-supporter.ch",
            "homepage@zsc-supporter.ch"
          ],
          "Data": "Date: Mon, 21 Feb 2022 16:43:56 +0100 (CET)\r\nFrom: donotreply@zsc-supporter.ch\r\nTo: kasse@zsc-supporter.ch, tickets@zsc-supporter.ch,\r\n\thomepage@zsc-supporter.ch\r\nMessage-ID: \u003c1699206600.1.1645458236263@silicon.home\u003e\r\nSubject: =?UTF-8?Q?ZSC_Supporter_Ticketing:_1_Tickets_f=C3=BCr_d?=\r\n =?UTF-8?Q?as_Spiel_vom_10.09.2021_wurden_reserviert?=\r\nMIME-Version: 1.0\r\nContent-Type: multipart/mixed; \r\n\tboundary=\"----=_Part_0_229907978.1645458236232\"\r\n\r\n------=_Part_0_229907978.1645458236232\r\nContent-Type: text/plain; charset=UTF-8\r\nContent-Transfer-Encoding: quoted-printable\r\n\r\nNeue Ticketbestellung\r\n\r\nSpiel vom: 22.02.2022, ZSC Lions - EV Zug\r\nF=C3=BCr Mitglied: Ren=C3=A9 Sterchi\r\nAnzahl Tickets Total: 1\r\nAnzahl Tickets Gratis: 1\r\nRechnungsbetrag: 0.00\r\nZustellung: Post\r\n\r\nDie Rechnung findest Du als PDF im Anhang.\r\n\r\n------=_Part_0_229907978.1645458236232--",
          "Helo": "silicon.home"
        }
      }
    ]
  }
       */

}
