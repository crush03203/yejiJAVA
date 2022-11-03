package kr.or.ddit.comm.dao;

import java.util.List;

import kr.or.ddit.comm.vo.AtchFileVO;

public class AtchFileDaoImple extends MyBaitsDao implements IAtchFileDao {

	private static IAtchFileDao atchFileDao;

	private AtchFileDaoImple() {
	}

	public static IAtchFileDao getIntance() {
		if (atchFileDao == null) {
			atchFileDao = new AtchFileDaoImple();
		}
		return atchFileDao;
	}

	@Override
	public int insertAtchFile(AtchFileVO atchFileVO) {
		return insert("atchFile.insertAtchFile", atchFileVO);
	}

	@Override
	public int insertAtchFileDetail(AtchFileVO atchFileVO) {
		return insert("atchFile.insertAtchFileDetail", atchFileVO);
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO) {
		return selectList("atchFile.getAtchFileList", atchFileVO);
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) {
		return selectOne("atchFile.getAtchFileDetail", atchFileVO);
	}

}
