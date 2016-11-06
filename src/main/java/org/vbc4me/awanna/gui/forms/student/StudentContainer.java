package org.vbc4me.awanna.gui.forms.student;

import org.vbc4me.awanna.gui.forms.student.actions.CopyStudentRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.EditStudentRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.NewStudentRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.OpenStudentRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.SaveStudentRecordAction;

/**
 * Created by John Hameier on 10/21/2016.
 */
public final class StudentContainer {

    public StudentContainer() {}

    public final static RecordButtonPanel buttonPanel = new RecordButtonPanel();
    public final static StudentDisplayForm displayForm = new StudentDisplayForm();
    public final static StudentEditForm editForm = new StudentEditForm();
    public final static StudentTableModel tableModel = new StudentTableModel();

    public final static CopyStudentRecordAction copyAction = new CopyStudentRecordAction(null);
    public final static EditStudentRecordAction editAction = new EditStudentRecordAction(null);
    public final static NewStudentRecordAction newAction = new NewStudentRecordAction(null);
    public final static OpenStudentRecordAction openAction = new OpenStudentRecordAction(null);
    public final static SaveStudentRecordAction saveAction = new SaveStudentRecordAction(null);
}
