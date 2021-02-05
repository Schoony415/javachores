import java.util.Locale;

public class Board {
    private Piece[][] masterBoard;

    public Board(Boolean fill){
        this.masterBoard = new Piece[8][8];
        if(fill){//if fill = true
            String w = "White";
            String b = "Black";
            this.masterBoard[0][0] = new Piece("Rook", b);
            this.masterBoard[0][1] = new Piece("Knight", b);
            this.masterBoard[0][2] = new Piece("Bishop",b);
            this.masterBoard[0][3] = new Piece("Queen", b);
            this.masterBoard[0][4] = new Piece("King", b);
            this.masterBoard[0][5] = new Piece("Bishop", b);
            this.masterBoard[0][6] = new Piece("Knight", b);
            this.masterBoard[0][7] = new Piece("Rook", b);
            for(int i = 0;i<8;i++) this.masterBoard[1][i] = new Piece("Pawn", b);
            for(int c = 2;c<6;c++) for(int r = 0;r<8;r++) this.masterBoard[c][r] = new Piece();
            this.masterBoard[7][0] = new Piece("Rook", w);
            this.masterBoard[7][1] = new Piece("Knight", w);
            this.masterBoard[7][2] = new Piece("Bishop",w);
            this.masterBoard[7][3] = new Piece("Queen", w);
            this.masterBoard[7][4] = new Piece("King", w);
            this.masterBoard[7][5] = new Piece("Bishop", w);
            this.masterBoard[7][6] = new Piece("Knight", w);
            this.masterBoard[7][7] = new Piece("Rook", w);
            for(int i = 0;i<8;i++) this.masterBoard[6][i] = new Piece("Pawn", w);
        }
    }

    public void movePiece(String init, String destination){
        //going to load up four numbers to be passed into the other movepiece to let it do the logic
        int[] retargs = new int[4];
        int[] tempars = new int[2];
        tempars = boardPlace(init);
        retargs[0]=tempars[0];
        retargs[1]=tempars[1];
        tempars=boardPlace(destination);
        retargs[2]=tempars[0];
        retargs[3]=tempars[1];
        System.out.println("Attempting move "+masterBoard[retargs[1]][retargs[0]]+" from "+init+" ("+retargs[0]+","+retargs[1]+") to "+destination+" ("+retargs[2]+","+retargs[3]+") which is "+masterBoard[retargs[3]][retargs[2]]);
        this.movePiece(retargs[0],retargs[1],retargs[2],retargs[3]);
    }
    //turning words into numbers
    public int[] boardPlace(String posistion){
        //System.out.println("this goes into the get posistion");
        //System.out.println(""+posistion);
        int[] retint = new int[2];
        //System.out.println("this is going into switch");
        //System.out.println(""+posistion.substring(0,1));
        switch (posistion.substring(0,1).toLowerCase()){
            case "a":
                retint[0]=0;
                break;
            case "b":
                retint[0]=1;
                break;
            case "c":
                retint[0]=2;
                break;
            case "d":
                retint[0]=3;
                break;
            case "e":
                retint[0]=4;
                break;
            case "f":
                retint[0]=5;
                break;
            case "g":
                retint[0]=6;
                break;
            case "h":
                retint[0]=7;
                break;
        }
        //System.out.println(posistion.substring(1,2));
        retint[1]= Math.abs(Integer.parseInt(posistion.substring(1,2))-8);
        //System.out.println("this is being returned from get posistion");
        //System.out.println(""+retint[0]+retint[1]);
        return retint;
    }
    //an operation for castling
    public void movePiece(String king, String rook, boolean Castle){
        if(Castle==false){System.out.println("WTF!!!!");return;}
        int[] kingnum = new int[2];
        kingnum = this.boardPlace(king);
        king = king.toLowerCase();
        System.out.println("king to castle "+masterBoard[kingnum[1]][kingnum[0]] +" from "+king+" has moved: "+masterBoard[kingnum[1]][kingnum[0]].pieceHasMoved);
        //making sure we have a king, using a NOR in the if
        //System.out.println("King Black comp: "+masterBoard[kingnum[1]][kingnum[0]].toString().equals("[KB]")+"/ king White comp: "+masterBoard[kingnum[1]][kingnum[0]].toString().equals("[KW]"));
        if(!(masterBoard[kingnum[1]][kingnum[0]].toString().equals("[KB]")
                ||masterBoard[kingnum[1]][kingnum[0]].toString().equals("[KW]"))){
            System.out.println("This is not a king");return;}
        int[] rooknum = new int[2];
        rooknum = this.boardPlace(rook);
        rook = rook.toLowerCase();
        System.out.println("king to castle "+masterBoard[rooknum[1]][rooknum[0]] +" from "+rook+" has moved: "+masterBoard[rooknum[1]][rooknum[0]].pieceHasMoved);
        if(!(masterBoard[rooknum[1]][rooknum[0]].toString().equals("[RB]")
                ||masterBoard[rooknum[1]][rooknum[0]].toString().equals("[RW]"))){
            System.out.println("This is not a rook");return;}
        //-------------------------------------
        //move the king two squares to the rook
        //for white
        //short side will be king g1 rook f1
        if((masterBoard[kingnum[1]][kingnum[0]].pieceHasMoved==false)
                && (masterBoard[rooknum[1]][rooknum[0]].pieceHasMoved==false)
                && (rook.equals("h1"))){
            System.out.println("--short side white castle");
            movePiece(kingnum[0],kingnum[1],6,7,true);
            movePiece(rooknum[0],rooknum[1],5,7,true);
        }else
        //long side will be king c1 rook d1
        if((masterBoard[kingnum[1]][kingnum[0]].pieceHasMoved==false)
                && (masterBoard[rooknum[1]][rooknum[0]].pieceHasMoved==false)
                && (rook.equals("a1"))){
            System.out.println("--long side white castle");
            movePiece(kingnum[0],kingnum[1],1,7,true);
            movePiece(rooknum[0],rooknum[1],2,7,true);
        }else
        //for black
        //short side will be king g8 rook f8
        //System.out.println("rook = h8 : "+rook.equals("h8"));
        if((masterBoard[kingnum[1]][kingnum[0]].pieceHasMoved==false)
                && (masterBoard[rooknum[1]][rooknum[0]].pieceHasMoved==false)
                && (rook.equals("h8"))){
            System.out.println("--short side black castle");
            movePiece(kingnum[0],kingnum[1],6,0,true);
            movePiece(rooknum[0],rooknum[1],5,0,true);
        }else
        //long side will be king c8 rook d8
        if((masterBoard[kingnum[1]][kingnum[0]].pieceHasMoved==false)
                && (masterBoard[rooknum[1]][rooknum[0]].pieceHasMoved==false)
                && (rook.equals("a8"))){
            System.out.println("--long side black castle");
            movePiece(kingnum[0],kingnum[1],1,0,true);
            movePiece(rooknum[0],rooknum[1],2,0,true);
        }
        //else
        else {System.out.println("--bad castle, no move");}

    }
    //special movePiece for castle
    public  void  movePiece(int icolumn, int irow, int fcolumn, int frow, boolean castle){
        if(castle == false){System.out.println("--Not a castle");movePiece(icolumn,irow,fcolumn,frow);return;}
        System.out.println("--castle move");
        masterBoard[frow][fcolumn] = masterBoard[irow][icolumn];
        masterBoard[irow][icolumn] = new Piece();
        masterBoard[frow][fcolumn].pieceHasMoved = true;
    }
    //movement using row and column call out
    //initial row column, final row column
    public void movePiece(int icolumn, int irow, int fcolumn, int frow ){
        boolean validmove = false; //masterBoard[irow][icolumn].validMove(frow, fcolumn); //need variable, probably will kill method
        int dif = 0;
        switch (masterBoard[irow][icolumn].moveType) {
            case "D": //daigonal
                dif = Math.abs(irow-frow); //only checks if the diagonal happens
                if(dif == Math.abs(icolumn-fcolumn)){
                    System.out.println("--diagonal true");
                    validmove = true;
                }
                break;
            case "S": //Straight
                //System.out.println("--checking straight case");
                if(0==(irow-frow)
                        || 0==(icolumn-fcolumn) ){ //nor statement to make sure only on direction
                    System.out.println("--Stright true");
                    validmove = true; //not checking for pieces in the way!!
                }
                break;
            case "P": //Pawn
                //row and column nomenclature is broken but I can't fix it
                //System.out.println("Pawn blck");
                //System.out.println("row:"+irow+",col:"+icolumn+";row:"+frow+",col:"+fcolumn);
                //System.out.println("Piece at "+irow+","+icolumn+" is "+masterBoard[irow][icolumn]+" and is "+masterBoard[irow][icolumn].pawnHasMoved);
                //if column doesn't change but row does by 1
                if(1==Math.abs(irow-frow)
                        && 0==(icolumn-fcolumn)) {
                    //masterBoard[irow][icolumn].pawnHasMoved = true;
                    System.out.println("--pawn move 1");
                    validmove=true;
                }else
                //if column doesn't change but row does by 2 on initial pawn move
                if(!masterBoard[irow][icolumn].pieceHasMoved
                        && 2==Math.abs(irow-frow)
                        && 0==icolumn-fcolumn){
                    //masterBoard[irow][icolumn].pawnHasMoved = true;
                    System.out.println("--pawn move 2");
                    validmove=true;
                }else
                //if pawn attacks,
                //need to add ability to check forwardness
                //need to add check for piece in location
                if(1==Math.abs(irow-frow) && 1==Math.abs(icolumn-fcolumn) ){
                    //masterBoard[irow][icolumn].pawnHasMoved = true;
                    System.out.println("--pawn move to attack");
                    validmove=true;
                }
                break;
            case "K": //king
                if((1==Math.abs(irow-frow) && 1==Math.abs(icolumn-fcolumn))
                        ||(1==Math.abs(irow-frow) && 0==Math.abs(icolumn-fcolumn))
                        ||(0==Math.abs(irow-frow) && 1==Math.abs(icolumn-fcolumn)) ){//king only moves one space any direction
                    System.out.println("--king true");
                    validmove = true; //not checking for pieces in the way!!
                }
                break;
            case "Q": //queen
                //copy from staright and diagonal
                //System.out.println("--Queen move");
                dif = Math.abs(irow-frow); //only checks if the diagonal happens
                if(dif == Math.abs(icolumn-fcolumn)){
                    System.out.println("--diagonal Q true");
                    validmove = true;
                }else if(0==(irow-frow) || 0==(icolumn-fcolumn) ){ //nor statement to make sure only on direction
                    System.out.println("--Stright Q true");
                    validmove = true; //not checking for pieces in the way!!
                }
                break;
            case "L": //Knight
                //L shapes
                //System.out.println("--inside the knight case");
                if((2==Math.abs(irow-frow) && 1==Math.abs(icolumn-fcolumn) )
                        ||((1==Math.abs(irow-frow) && 2==Math.abs(icolumn-fcolumn) ))){
                    //so I checked that you did a two by one diag
                    System.out.println("--knight move true");
                    validmove=true;
                }


                break;
        }
        //once we know it's a valid move, we need to check to kill a piece and switch the array locations
        //don't need to switch just place a blank where we were after move
        if (validmove==true) {
            masterBoard[frow][fcolumn] = masterBoard[irow][icolumn];
            masterBoard[irow][icolumn] = new Piece();
            masterBoard[frow][fcolumn].pieceHasMoved = true;
        }else{System.out.println("Bad move");}

    }
    //to string what piece is at location
    public String pieceAt(String location){
        int[] loc = new int[2];
        loc=this.boardPlace(location);
        String tempstr = "";
        tempstr = "The piece at ";
        tempstr += location;
        tempstr += " : ";
        tempstr += masterBoard[loc[0]][loc[1]];
        return tempstr;
    }
    public String toString(){
        String tempstring = "";
        for(Piece[] row : masterBoard){
            for(Piece column : row) {
                tempstring+=column;
            }
            tempstring+="\n";
        }
        return tempstring;
    }

}
