/*******************************************************************************
  * Copyright (C) 2019 ICCU - Istituto Centrale per il Catalogo Unico
  *
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU Affero General Public License as published
  * by the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU Affero General Public License for more details.
  *
  * You should have received a copy of the GNU Affero General Public License
  * along with this program. If not, see <http://www.gnu.org/licenses/>.
  ******************************************************************************/
/*
 * TrTitLuo.h
 *
 *  Created on: 16-ott-2009
 *      Author: Arge
 */


#ifndef TRTITLUO_H_
#define TRTITLUO_H_

#include "Tb.h"

class TrTitLuo: public Tb {
public:
	enum fieldId {
		bid,
		lid,
		tp_luogo,
		nota_tit_luo,
		ute_ins,
		ts_ins,
		ute_var,
		ts_var,
		fl_canc
		};

	TrTitLuo(CFile *tbIn, CFile *tbOffsetIn, char *offsetBufferTbPtr, long elementsTb, int keyPlusOffsetPlusLfLength, int key_length);
	virtual ~TrTitLuo();
};

#endif /* TRTITLUO_H_ */