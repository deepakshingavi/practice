public class StringLookup {

    public static void main(String[] args) {
        String rfResp = "[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m_[0m[2;1H[4mR[0m[4mD[0m[4mT[0m[4m0[0m[4m0[0m[4m5[0m[24m[2J[2J[H7[1;7HDeposit[0m[23m[22m87[1;1H[24mMRG[0m[24m87[2;1HLPN:[0m87[3;1H[24mL000000004VS [0m[24m87[4;1HItm:[0m87[5;1H[24mTEST_SWT01 [0m[24m87[6;1HCli:[0m87[6;5H[24mDFS [0m[24m87[7;1H[24mtest item01 [0m[24m87[8;1HQ:[0m87[8;4H[24m25 [0m[24m87[12;1HLoc:[0m87[12;6H[24mPWG01032 [0m[24m87[13;6H[24mSWTAREA - WZ-GL[0m[24m87[9;1HLPN:[0m87[10;1H[24mL000000004VS [0m[24m87[14;1HLoc:[0m87[39;9H[2KForm: DEPOSIT_A[0m[39;37HField: dstloc[0m[15;1H[4m[7m____________________[0m[24m[48m87[39;9H[2KForm: DEPOSIT_A[0m[39;37HField: dstloc[0m[15;1H[4m[7m____________________[0m[24m[48m87[15;1H";
        String prefix = "PWG"; // assuming all the string you want have common prefix
        int lengthOfLocValue = 8;
        if(rfResp.contains(prefix)) { // if the string with it exists
            int startIndex = rfResp.indexOf(prefix);
            String loc = rfResp.substring(startIndex,startIndex + lengthOfLocValue); // assuming length of loc value as 8
            System.out.println(loc);
        }
    }

}
